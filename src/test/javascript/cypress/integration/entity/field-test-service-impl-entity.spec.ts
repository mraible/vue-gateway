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

describe('FieldTestServiceImplEntity e2e test', () => {
  const fieldTestServiceImplEntityPageUrl = '/field-test-service-impl-entity';
  const fieldTestServiceImplEntityPageUrlPattern = new RegExp('/field-test-service-impl-entity(\\?.*)?$');
  const username = Cypress.env('E2E_USERNAME') ?? 'admin';
  const password = Cypress.env('E2E_PASSWORD') ?? 'admin';
  const fieldTestServiceImplEntitySample = {
    stringRequiredMika: 'background violet',
    integerRequiredMika: 22869,
    longRequiredMika: 94296,
    floatRequiredMika: 24803,
    doubleRequiredMika: 80292,
    bigDecimalRequiredMika: 5806,
    localDateRequiredMika: '2016-02-08',
    instanteRequiredMika: '2016-02-08T02:53:07.961Z',
    zonedDateTimeRequiredMika: '2016-02-08T16:35:28.628Z',
    durationRequiredMika: 25957,
    booleanRequiredMika: true,
    enumRequiredMika: 'ENUM_VALUE_3',
    uuidRequiredMika: '5858ed96-b89b-446c-b89c-aa645a6591a1',
    byteImageRequiredMika: 'Li4vZmFrZS1kYXRhL2Jsb2IvaGlwc3Rlci5wbmc=',
    byteImageRequiredMikaContentType: 'unknown',
    byteAnyRequiredMika: 'Li4vZmFrZS1kYXRhL2Jsb2IvaGlwc3Rlci5wbmc=',
    byteAnyRequiredMikaContentType: 'unknown',
    byteTextRequiredMika: 'Li4vZmFrZS1kYXRhL2Jsb2IvaGlwc3Rlci50eHQ=',
  };

  let fieldTestServiceImplEntity: any;

  before(() => {
    cy.window().then(win => {
      win.sessionStorage.clear();
    });
    cy.visit('');
    cy.login(username, password);
    cy.get(entityItemSelector).should('exist');
  });

  beforeEach(() => {
    cy.intercept('GET', '/api/field-test-service-impl-entities+(?*|)').as('entitiesRequest');
    cy.intercept('POST', '/api/field-test-service-impl-entities').as('postEntityRequest');
    cy.intercept('DELETE', '/api/field-test-service-impl-entities/*').as('deleteEntityRequest');
  });

  afterEach(() => {
    if (fieldTestServiceImplEntity) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/field-test-service-impl-entities/${fieldTestServiceImplEntity.id}`,
      }).then(() => {
        fieldTestServiceImplEntity = undefined;
      });
    }
  });

  it('FieldTestServiceImplEntities menu should load FieldTestServiceImplEntities page', () => {
    cy.visit('/');
    cy.clickOnEntityMenuItem('field-test-service-impl-entity');
    cy.wait('@entitiesRequest').then(({ response }) => {
      if (response!.body.length === 0) {
        cy.get(entityTableSelector).should('not.exist');
      } else {
        cy.get(entityTableSelector).should('exist');
      }
    });
    cy.getEntityHeading('FieldTestServiceImplEntity').should('exist');
    cy.url().should('match', fieldTestServiceImplEntityPageUrlPattern);
  });

  describe('FieldTestServiceImplEntity page', () => {
    describe('create button click', () => {
      beforeEach(() => {
        cy.visit(fieldTestServiceImplEntityPageUrl);
        cy.wait('@entitiesRequest');
      });

      it('should load create FieldTestServiceImplEntity page', () => {
        cy.get(entityCreateButtonSelector).click({ force: true });
        cy.url().should('match', new RegExp('/field-test-service-impl-entity/new$'));
        cy.getEntityCreateUpdateHeading('FieldTestServiceImplEntity');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', fieldTestServiceImplEntityPageUrlPattern);
      });
    });

    describe('with existing value', () => {
      beforeEach(() => {
        cy.authenticatedRequest({
          method: 'POST',
          url: '/api/field-test-service-impl-entities',
          body: fieldTestServiceImplEntitySample,
        }).then(({ body }) => {
          fieldTestServiceImplEntity = body;

          cy.intercept(
            {
              method: 'GET',
              url: '/api/field-test-service-impl-entities+(?*|)',
              times: 1,
            },
            {
              statusCode: 200,
              body: [fieldTestServiceImplEntity],
            }
          ).as('entitiesRequestInternal');
        });

        cy.visit(fieldTestServiceImplEntityPageUrl);

        cy.wait('@entitiesRequestInternal');
      });

      it('detail button click should load details FieldTestServiceImplEntity page', () => {
        cy.get(entityDetailsButtonSelector).first().click();
        cy.getEntityDetailsHeading('fieldTestServiceImplEntity');
        cy.get(entityDetailsBackButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', fieldTestServiceImplEntityPageUrlPattern);
      });

      it('edit button click should load edit FieldTestServiceImplEntity page', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('FieldTestServiceImplEntity');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', fieldTestServiceImplEntityPageUrlPattern);
      });

      it('last delete button click should delete instance of FieldTestServiceImplEntity', () => {
        cy.get(entityDeleteButtonSelector).last().click();
        cy.getEntityDeleteDialogHeading('fieldTestServiceImplEntity').should('exist');
        cy.get(entityConfirmDeleteButtonSelector).click({ force: true });
        cy.wait('@deleteEntityRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(204);
        });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', fieldTestServiceImplEntityPageUrlPattern);

        fieldTestServiceImplEntity = undefined;
      });
    });
  });

  describe('new FieldTestServiceImplEntity page', () => {
    beforeEach(() => {
      cy.visit(`${fieldTestServiceImplEntityPageUrl}`);
      cy.get(entityCreateButtonSelector).click({ force: true });
      cy.getEntityCreateUpdateHeading('FieldTestServiceImplEntity');
    });

    it('should create an instance of FieldTestServiceImplEntity', () => {
      cy.get(`[data-cy="stringMika"]`).type('Mouse gold panel').should('have.value', 'Mouse gold panel');

      cy.get(`[data-cy="stringRequiredMika"]`).type('Missouri Berkshire').should('have.value', 'Missouri Berkshire');

      cy.get(`[data-cy="stringMinlengthMika"]`).type('Chicken Account Peso').should('have.value', 'Chicken Account Peso');

      cy.get(`[data-cy="stringMaxlengthMika"]`).type('Cambridgeshire lime ').should('have.value', 'Cambridgeshire lime ');

      cy.get(`[data-cy="integerMika"]`).type('73468').should('have.value', '73468');

      cy.get(`[data-cy="integerRequiredMika"]`).type('92587').should('have.value', '92587');

      cy.get(`[data-cy="integerMinMika"]`).type('17593').should('have.value', '17593');

      cy.get(`[data-cy="integerMaxMika"]`).type('10').should('have.value', '10');

      cy.get(`[data-cy="longMika"]`).type('67519').should('have.value', '67519');

      cy.get(`[data-cy="longRequiredMika"]`).type('56362').should('have.value', '56362');

      cy.get(`[data-cy="longMinMika"]`).type('10950').should('have.value', '10950');

      cy.get(`[data-cy="longMaxMika"]`).type('70').should('have.value', '70');

      cy.get(`[data-cy="floatMika"]`).type('30587').should('have.value', '30587');

      cy.get(`[data-cy="floatRequiredMika"]`).type('28849').should('have.value', '28849');

      cy.get(`[data-cy="floatMinMika"]`).type('33353').should('have.value', '33353');

      cy.get(`[data-cy="floatMaxMika"]`).type('81').should('have.value', '81');

      cy.get(`[data-cy="doubleRequiredMika"]`).type('15500').should('have.value', '15500');

      cy.get(`[data-cy="doubleMinMika"]`).type('7497').should('have.value', '7497');

      cy.get(`[data-cy="doubleMaxMika"]`).type('53').should('have.value', '53');

      cy.get(`[data-cy="bigDecimalRequiredMika"]`).type('85551').should('have.value', '85551');

      cy.get(`[data-cy="bigDecimalMinMika"]`).type('17979').should('have.value', '17979');

      cy.get(`[data-cy="bigDecimalMaxMika"]`).type('55').should('have.value', '55');

      cy.get(`[data-cy="localDateMika"]`).type('2016-02-07').should('have.value', '2016-02-07');

      cy.get(`[data-cy="localDateRequiredMika"]`).type('2016-02-08').should('have.value', '2016-02-08');

      cy.get(`[data-cy="instantMika"]`).type('2016-02-08T06:59').should('have.value', '2016-02-08T06:59');

      cy.get(`[data-cy="instanteRequiredMika"]`).type('2016-02-08T09:48').should('have.value', '2016-02-08T09:48');

      cy.get(`[data-cy="zonedDateTimeMika"]`).type('2016-02-07T19:20').should('have.value', '2016-02-07T19:20');

      cy.get(`[data-cy="zonedDateTimeRequiredMika"]`).type('2016-02-08T00:33').should('have.value', '2016-02-08T00:33');

      cy.get(`[data-cy="durationMika"]`).type('PT15M').should('have.value', 'PT15M');

      cy.get(`[data-cy="durationRequiredMika"]`).type('PT56M').should('have.value', 'PT56M');

      cy.get(`[data-cy="booleanMika"]`).should('not.be.checked');
      cy.get(`[data-cy="booleanMika"]`).click().should('be.checked');

      cy.get(`[data-cy="booleanRequiredMika"]`).should('not.be.checked');
      cy.get(`[data-cy="booleanRequiredMika"]`).click().should('be.checked');

      cy.get(`[data-cy="enumMika"]`).select('ENUM_VALUE_1');

      cy.get(`[data-cy="enumRequiredMika"]`).select('ENUM_VALUE_2');

      cy.get(`[data-cy="uuidMika"]`)
        .type('69e66342-243f-49e0-bdb8-be1dedb7f1c2')
        .invoke('val')
        .should('match', new RegExp('69e66342-243f-49e0-bdb8-be1dedb7f1c2'));

      cy.get(`[data-cy="uuidRequiredMika"]`)
        .type('63019d3a-d201-4b7d-8858-4dc59bfeaf8e')
        .invoke('val')
        .should('match', new RegExp('63019d3a-d201-4b7d-8858-4dc59bfeaf8e'));

      cy.setFieldImageAsBytesOfEntity('byteImageMika', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteImageRequiredMika', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteImageMinbytesMika', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteImageMaxbytesMika', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteAnyMika', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteAnyRequiredMika', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteAnyMinbytesMika', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteAnyMaxbytesMika', 'integration-test.png', 'image/png');

      cy.get(`[data-cy="byteTextMika"]`)
        .type('../fake-data/blob/hipster.txt')
        .invoke('val')
        .should('match', new RegExp('../fake-data/blob/hipster.txt'));

      cy.get(`[data-cy="byteTextRequiredMika"]`)
        .type('../fake-data/blob/hipster.txt')
        .invoke('val')
        .should('match', new RegExp('../fake-data/blob/hipster.txt'));

      // since cypress clicks submit too fast before the blob fields are validated
      cy.wait(200); // eslint-disable-line cypress/no-unnecessary-waiting
      cy.get(entityCreateSaveButtonSelector).click();

      cy.wait('@postEntityRequest').then(({ response }) => {
        expect(response!.statusCode).to.equal(201);
        fieldTestServiceImplEntity = response!.body;
      });
      cy.wait('@entitiesRequest').then(({ response }) => {
        expect(response!.statusCode).to.equal(200);
      });
      cy.url().should('match', fieldTestServiceImplEntityPageUrlPattern);
    });
  });
});
