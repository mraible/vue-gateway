import { entityItemSelector } from '../../support/commands';
import {
  entityTableSelector,
  entityDetailsButtonSelector,
  entityDetailsBackButtonSelector,
  entityCreateButtonSelector,
  entityCreateSaveButtonSelector,
  entityCreateCancelButtonSelector,
  entityEditButtonSelector,
  entityDeleteButtonSelector,
  entityConfirmDeleteButtonSelector,
} from '../../support/entity';

describe('FieldTestPaginationEntity e2e test', () => {
  const fieldTestPaginationEntityPageUrl = '/field-test-pagination-entity';
  const fieldTestPaginationEntityPageUrlPattern = new RegExp('/field-test-pagination-entity(\\?.*)?$');
  const username = Cypress.env('E2E_USERNAME') ?? 'admin';
  const password = Cypress.env('E2E_PASSWORD') ?? 'admin';
  const fieldTestPaginationEntitySample = {
    stringRequiredAlice: 'parsing Sausages',
    integerRequiredAlice: 50640,
    longRequiredAlice: 61673,
    floatRequiredAlice: 1024,
    doubleRequiredAlice: 87850,
    bigDecimalRequiredAlice: 56816,
    localDateRequiredAlice: '2016-02-08',
    instanteRequiredAlice: '2016-02-08T04:04:06.933Z',
    zonedDateTimeRequiredAlice: '2016-02-07T23:57:02.202Z',
    durationRequiredAlice: 14830,
    booleanRequiredAlice: true,
    enumRequiredAlice: 'ENUM_VALUE_2',
    uuidRequiredAlice: '51eedb72-fb54-4e7f-acc6-7b251cf9b8ae',
    byteImageRequiredAlice: 'Li4vZmFrZS1kYXRhL2Jsb2IvaGlwc3Rlci5wbmc=',
    byteImageRequiredAliceContentType: 'unknown',
    byteAnyRequiredAlice: 'Li4vZmFrZS1kYXRhL2Jsb2IvaGlwc3Rlci5wbmc=',
    byteAnyRequiredAliceContentType: 'unknown',
    byteTextRequiredAlice: 'Li4vZmFrZS1kYXRhL2Jsb2IvaGlwc3Rlci50eHQ=',
  };

  let fieldTestPaginationEntity: any;

  before(() => {
    cy.window().then(win => {
      win.sessionStorage.clear();
    });
    cy.visit('');
    cy.login(username, password);
    cy.get(entityItemSelector).should('exist');
  });

  beforeEach(() => {
    cy.intercept('GET', '/api/field-test-pagination-entities+(?*|)').as('entitiesRequest');
    cy.intercept('POST', '/api/field-test-pagination-entities').as('postEntityRequest');
    cy.intercept('DELETE', '/api/field-test-pagination-entities/*').as('deleteEntityRequest');
  });

  afterEach(() => {
    if (fieldTestPaginationEntity) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/field-test-pagination-entities/${fieldTestPaginationEntity.id}`,
      }).then(() => {
        fieldTestPaginationEntity = undefined;
      });
    }
  });

  it('FieldTestPaginationEntities menu should load FieldTestPaginationEntities page', () => {
    cy.visit('/');
    cy.clickOnEntityMenuItem('field-test-pagination-entity');
    cy.wait('@entitiesRequest').then(({ response }) => {
      if (response!.body.length === 0) {
        cy.get(entityTableSelector).should('not.exist');
      } else {
        cy.get(entityTableSelector).should('exist');
      }
    });
    cy.getEntityHeading('FieldTestPaginationEntity').should('exist');
    cy.url().should('match', fieldTestPaginationEntityPageUrlPattern);
  });

  describe('FieldTestPaginationEntity page', () => {
    describe('create button click', () => {
      beforeEach(() => {
        cy.visit(fieldTestPaginationEntityPageUrl);
        cy.wait('@entitiesRequest');
      });

      it('should load create FieldTestPaginationEntity page', () => {
        cy.get(entityCreateButtonSelector).click({ force: true });
        cy.url().should('match', new RegExp('/field-test-pagination-entity/new$'));
        cy.getEntityCreateUpdateHeading('FieldTestPaginationEntity');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', fieldTestPaginationEntityPageUrlPattern);
      });
    });

    describe('with existing value', () => {
      beforeEach(() => {
        cy.authenticatedRequest({
          method: 'POST',
          url: '/api/field-test-pagination-entities',
          body: fieldTestPaginationEntitySample,
        }).then(({ body }) => {
          fieldTestPaginationEntity = body;

          cy.intercept(
            {
              method: 'GET',
              url: '/api/field-test-pagination-entities+(?*|)',
              times: 1,
            },
            {
              statusCode: 200,
              headers: {
                link: '<http://localhost/api/field-test-pagination-entities?page=0&size=20>; rel="last",<http://localhost/api/field-test-pagination-entities?page=0&size=20>; rel="first"',
              },
              body: [fieldTestPaginationEntity],
            }
          ).as('entitiesRequestInternal');
        });

        cy.visit(fieldTestPaginationEntityPageUrl);

        cy.wait('@entitiesRequestInternal');
      });

      it('detail button click should load details FieldTestPaginationEntity page', () => {
        cy.get(entityDetailsButtonSelector).first().click();
        cy.getEntityDetailsHeading('fieldTestPaginationEntity');
        cy.get(entityDetailsBackButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', fieldTestPaginationEntityPageUrlPattern);
      });

      it('edit button click should load edit FieldTestPaginationEntity page', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('FieldTestPaginationEntity');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', fieldTestPaginationEntityPageUrlPattern);
      });

      it('last delete button click should delete instance of FieldTestPaginationEntity', () => {
        cy.get(entityDeleteButtonSelector).last().click();
        cy.getEntityDeleteDialogHeading('fieldTestPaginationEntity').should('exist');
        cy.get(entityConfirmDeleteButtonSelector).click({ force: true });
        cy.wait('@deleteEntityRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(204);
        });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', fieldTestPaginationEntityPageUrlPattern);

        fieldTestPaginationEntity = undefined;
      });
    });
  });

  describe('new FieldTestPaginationEntity page', () => {
    beforeEach(() => {
      cy.visit(`${fieldTestPaginationEntityPageUrl}`);
      cy.get(entityCreateButtonSelector).click({ force: true });
      cy.getEntityCreateUpdateHeading('FieldTestPaginationEntity');
    });

    it('should create an instance of FieldTestPaginationEntity', () => {
      cy.get(`[data-cy="stringAlice"]`).type('Granite Dalasi Hat').should('have.value', 'Granite Dalasi Hat');

      cy.get(`[data-cy="stringRequiredAlice"]`).type('leverage Outdoors').should('have.value', 'leverage Outdoors');

      cy.get(`[data-cy="stringMinlengthAlice"]`).type('USB').should('have.value', 'USB');

      cy.get(`[data-cy="stringMaxlengthAlice"]`).type('access card').should('have.value', 'access card');

      cy.get(`[data-cy="stringPatternAlice"]`).type('jC').should('have.value', 'jC');

      cy.get(`[data-cy="integerAlice"]`).type('20081').should('have.value', '20081');

      cy.get(`[data-cy="integerRequiredAlice"]`).type('57008').should('have.value', '57008');

      cy.get(`[data-cy="integerMinAlice"]`).type('16937').should('have.value', '16937');

      cy.get(`[data-cy="integerMaxAlice"]`).type('4').should('have.value', '4');

      cy.get(`[data-cy="longAlice"]`).type('61812').should('have.value', '61812');

      cy.get(`[data-cy="longRequiredAlice"]`).type('82620').should('have.value', '82620');

      cy.get(`[data-cy="longMinAlice"]`).type('87525').should('have.value', '87525');

      cy.get(`[data-cy="longMaxAlice"]`).type('42').should('have.value', '42');

      cy.get(`[data-cy="floatAlice"]`).type('74857').should('have.value', '74857');

      cy.get(`[data-cy="floatRequiredAlice"]`).type('23900').should('have.value', '23900');

      cy.get(`[data-cy="floatMinAlice"]`).type('37450').should('have.value', '37450');

      cy.get(`[data-cy="floatMaxAlice"]`).type('0').should('have.value', '0');

      cy.get(`[data-cy="doubleRequiredAlice"]`).type('4703').should('have.value', '4703');

      cy.get(`[data-cy="doubleMinAlice"]`).type('29918').should('have.value', '29918');

      cy.get(`[data-cy="doubleMaxAlice"]`).type('46').should('have.value', '46');

      cy.get(`[data-cy="bigDecimalRequiredAlice"]`).type('26239').should('have.value', '26239');

      cy.get(`[data-cy="bigDecimalMinAlice"]`).type('43816').should('have.value', '43816');

      cy.get(`[data-cy="bigDecimalMaxAlice"]`).type('24').should('have.value', '24');

      cy.get(`[data-cy="localDateAlice"]`).type('2016-02-08').should('have.value', '2016-02-08');

      cy.get(`[data-cy="localDateRequiredAlice"]`).type('2016-02-08').should('have.value', '2016-02-08');

      cy.get(`[data-cy="instantAlice"]`).type('2016-02-08T14:11').should('have.value', '2016-02-08T14:11');

      cy.get(`[data-cy="instanteRequiredAlice"]`).type('2016-02-08T18:24').should('have.value', '2016-02-08T18:24');

      cy.get(`[data-cy="zonedDateTimeAlice"]`).type('2016-02-08T09:16').should('have.value', '2016-02-08T09:16');

      cy.get(`[data-cy="zonedDateTimeRequiredAlice"]`).type('2016-02-07T20:11').should('have.value', '2016-02-07T20:11');

      cy.get(`[data-cy="durationAlice"]`).type('PT23M').should('have.value', 'PT23M');

      cy.get(`[data-cy="durationRequiredAlice"]`).type('PT53M').should('have.value', 'PT53M');

      cy.get(`[data-cy="booleanAlice"]`).should('not.be.checked');
      cy.get(`[data-cy="booleanAlice"]`).click().should('be.checked');

      cy.get(`[data-cy="booleanRequiredAlice"]`).should('not.be.checked');
      cy.get(`[data-cy="booleanRequiredAlice"]`).click().should('be.checked');

      cy.get(`[data-cy="enumAlice"]`).select('ENUM_VALUE_1');

      cy.get(`[data-cy="enumRequiredAlice"]`).select('ENUM_VALUE_1');

      cy.get(`[data-cy="uuidAlice"]`)
        .type('caa8fb7c-afb2-491e-af16-e3134d01324c')
        .invoke('val')
        .should('match', new RegExp('caa8fb7c-afb2-491e-af16-e3134d01324c'));

      cy.get(`[data-cy="uuidRequiredAlice"]`)
        .type('1d98e3d4-a802-4c7b-96eb-a7bcdea0257f')
        .invoke('val')
        .should('match', new RegExp('1d98e3d4-a802-4c7b-96eb-a7bcdea0257f'));

      cy.setFieldImageAsBytesOfEntity('byteImageAlice', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteImageRequiredAlice', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteImageMinbytesAlice', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteImageMaxbytesAlice', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteAnyAlice', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteAnyRequiredAlice', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteAnyMinbytesAlice', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteAnyMaxbytesAlice', 'integration-test.png', 'image/png');

      cy.get(`[data-cy="byteTextAlice"]`)
        .type('../fake-data/blob/hipster.txt')
        .invoke('val')
        .should('match', new RegExp('../fake-data/blob/hipster.txt'));

      cy.get(`[data-cy="byteTextRequiredAlice"]`)
        .type('../fake-data/blob/hipster.txt')
        .invoke('val')
        .should('match', new RegExp('../fake-data/blob/hipster.txt'));

      // since cypress clicks submit too fast before the blob fields are validated
      cy.wait(200); // eslint-disable-line cypress/no-unnecessary-waiting
      cy.get(entityCreateSaveButtonSelector).click();

      cy.wait('@postEntityRequest').then(({ response }) => {
        expect(response!.statusCode).to.equal(201);
        fieldTestPaginationEntity = response!.body;
      });
      cy.wait('@entitiesRequest').then(({ response }) => {
        expect(response!.statusCode).to.equal(200);
      });
      cy.url().should('match', fieldTestPaginationEntityPageUrlPattern);
    });
  });
});
