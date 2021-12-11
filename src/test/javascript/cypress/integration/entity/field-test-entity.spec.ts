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

describe('FieldTestEntity e2e test', () => {
  const fieldTestEntityPageUrl = '/field-test-entity';
  const fieldTestEntityPageUrlPattern = new RegExp('/field-test-entity(\\?.*)?$');
  const username = Cypress.env('E2E_USERNAME') ?? 'admin';
  const password = Cypress.env('E2E_PASSWORD') ?? 'admin';
  const fieldTestEntitySample = {
    stringRequiredTom: 'payment Cote USB',
    numberPatternRequiredTom: '811849',
    integerRequiredTom: 11020,
    longRequiredTom: 50051,
    floatRequiredTom: 49499,
    doubleRequiredTom: 14176,
    bigDecimalRequiredTom: 35823,
    localDateRequiredTom: '2016-02-08',
    instantRequiredTom: '2016-02-08T07:11:38.392Z',
    zonedDateTimeRequiredTom: '2016-02-08T10:00:46.488Z',
    durationRequiredTom: 29692,
    booleanRequiredTom: true,
    enumRequiredTom: 'ENUM_VALUE_3',
    uuidRequiredTom: '8586043a-14f9-4c79-86ca-54bdf2474a9b',
    byteImageRequiredTom: 'Li4vZmFrZS1kYXRhL2Jsb2IvaGlwc3Rlci5wbmc=',
    byteImageRequiredTomContentType: 'unknown',
    byteAnyRequiredTom: 'Li4vZmFrZS1kYXRhL2Jsb2IvaGlwc3Rlci5wbmc=',
    byteAnyRequiredTomContentType: 'unknown',
    byteTextRequiredTom: 'Li4vZmFrZS1kYXRhL2Jsb2IvaGlwc3Rlci50eHQ=',
  };

  let fieldTestEntity: any;

  before(() => {
    cy.window().then(win => {
      win.sessionStorage.clear();
    });
    cy.visit('');
    cy.login(username, password);
    cy.get(entityItemSelector).should('exist');
  });

  beforeEach(() => {
    cy.intercept('GET', '/api/field-test-entities+(?*|)').as('entitiesRequest');
    cy.intercept('POST', '/api/field-test-entities').as('postEntityRequest');
    cy.intercept('DELETE', '/api/field-test-entities/*').as('deleteEntityRequest');
  });

  afterEach(() => {
    if (fieldTestEntity) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/field-test-entities/${fieldTestEntity.id}`,
      }).then(() => {
        fieldTestEntity = undefined;
      });
    }
  });

  it('FieldTestEntities menu should load FieldTestEntities page', () => {
    cy.visit('/');
    cy.clickOnEntityMenuItem('field-test-entity');
    cy.wait('@entitiesRequest').then(({ response }) => {
      if (response!.body.length === 0) {
        cy.get(entityTableSelector).should('not.exist');
      } else {
        cy.get(entityTableSelector).should('exist');
      }
    });
    cy.getEntityHeading('FieldTestEntity').should('exist');
    cy.url().should('match', fieldTestEntityPageUrlPattern);
  });

  describe('FieldTestEntity page', () => {
    describe('create button click', () => {
      beforeEach(() => {
        cy.visit(fieldTestEntityPageUrl);
        cy.wait('@entitiesRequest');
      });

      it('should load create FieldTestEntity page', () => {
        cy.get(entityCreateButtonSelector).click({ force: true });
        cy.url().should('match', new RegExp('/field-test-entity/new$'));
        cy.getEntityCreateUpdateHeading('FieldTestEntity');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', fieldTestEntityPageUrlPattern);
      });
    });

    describe('with existing value', () => {
      beforeEach(() => {
        cy.authenticatedRequest({
          method: 'POST',
          url: '/api/field-test-entities',
          body: fieldTestEntitySample,
        }).then(({ body }) => {
          fieldTestEntity = body;

          cy.intercept(
            {
              method: 'GET',
              url: '/api/field-test-entities+(?*|)',
              times: 1,
            },
            {
              statusCode: 200,
              body: [fieldTestEntity],
            }
          ).as('entitiesRequestInternal');
        });

        cy.visit(fieldTestEntityPageUrl);

        cy.wait('@entitiesRequestInternal');
      });

      it('detail button click should load details FieldTestEntity page', () => {
        cy.get(entityDetailsButtonSelector).first().click();
        cy.getEntityDetailsHeading('fieldTestEntity');
        cy.get(entityDetailsBackButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', fieldTestEntityPageUrlPattern);
      });

      it('edit button click should load edit FieldTestEntity page', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('FieldTestEntity');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', fieldTestEntityPageUrlPattern);
      });

      it('last delete button click should delete instance of FieldTestEntity', () => {
        cy.get(entityDeleteButtonSelector).last().click();
        cy.getEntityDeleteDialogHeading('fieldTestEntity').should('exist');
        cy.get(entityConfirmDeleteButtonSelector).click({ force: true });
        cy.wait('@deleteEntityRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(204);
        });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', fieldTestEntityPageUrlPattern);

        fieldTestEntity = undefined;
      });
    });
  });

  describe('new FieldTestEntity page', () => {
    beforeEach(() => {
      cy.visit(`${fieldTestEntityPageUrl}`);
      cy.get(entityCreateButtonSelector).click({ force: true });
      cy.getEntityCreateUpdateHeading('FieldTestEntity');
    });

    it('should create an instance of FieldTestEntity', () => {
      cy.get(`[data-cy="stringTom"]`).type('Internal Buckinghamshire').should('have.value', 'Internal Buckinghamshire');

      cy.get(`[data-cy="stringRequiredTom"]`).type('interface').should('have.value', 'interface');

      cy.get(`[data-cy="stringMinlengthTom"]`).type('Norwegian Dinar Shirt').should('have.value', 'Norwegian Dinar Shirt');

      cy.get(`[data-cy="stringMaxlengthTom"]`).type('clicks-and-mortar').should('have.value', 'clicks-and-mortar');

      cy.get(`[data-cy="stringPatternTom"]`).type('pnBGz').should('have.value', 'pnBGz');

      cy.get(`[data-cy="numberPatternTom"]`).type('427800').should('have.value', '427800');

      cy.get(`[data-cy="numberPatternRequiredTom"]`).type('1').should('have.value', '1');

      cy.get(`[data-cy="integerTom"]`).type('87517').should('have.value', '87517');

      cy.get(`[data-cy="integerRequiredTom"]`).type('83007').should('have.value', '83007');

      cy.get(`[data-cy="integerMinTom"]`).type('76191').should('have.value', '76191');

      cy.get(`[data-cy="integerMaxTom"]`).type('59').should('have.value', '59');

      cy.get(`[data-cy="longTom"]`).type('36575').should('have.value', '36575');

      cy.get(`[data-cy="longRequiredTom"]`).type('12116').should('have.value', '12116');

      cy.get(`[data-cy="longMinTom"]`).type('29703').should('have.value', '29703');

      cy.get(`[data-cy="longMaxTom"]`).type('95').should('have.value', '95');

      cy.get(`[data-cy="floatTom"]`).type('57224').should('have.value', '57224');

      cy.get(`[data-cy="floatRequiredTom"]`).type('78473').should('have.value', '78473');

      cy.get(`[data-cy="floatMinTom"]`).type('27081').should('have.value', '27081');

      cy.get(`[data-cy="floatMaxTom"]`).type('14').should('have.value', '14');

      cy.get(`[data-cy="doubleRequiredTom"]`).type('85310').should('have.value', '85310');

      cy.get(`[data-cy="doubleMinTom"]`).type('79218').should('have.value', '79218');

      cy.get(`[data-cy="doubleMaxTom"]`).type('71').should('have.value', '71');

      cy.get(`[data-cy="bigDecimalRequiredTom"]`).type('27119').should('have.value', '27119');

      cy.get(`[data-cy="bigDecimalMinTom"]`).type('23091').should('have.value', '23091');

      cy.get(`[data-cy="bigDecimalMaxTom"]`).type('21').should('have.value', '21');

      cy.get(`[data-cy="localDateTom"]`).type('2016-02-08').should('have.value', '2016-02-08');

      cy.get(`[data-cy="localDateRequiredTom"]`).type('2016-02-08').should('have.value', '2016-02-08');

      cy.get(`[data-cy="instantTom"]`).type('2016-02-07T21:38').should('have.value', '2016-02-07T21:38');

      cy.get(`[data-cy="instantRequiredTom"]`).type('2016-02-08T06:51').should('have.value', '2016-02-08T06:51');

      cy.get(`[data-cy="zonedDateTimeTom"]`).type('2016-02-08T16:52').should('have.value', '2016-02-08T16:52');

      cy.get(`[data-cy="zonedDateTimeRequiredTom"]`).type('2016-02-08T01:53').should('have.value', '2016-02-08T01:53');

      cy.get(`[data-cy="durationTom"]`).type('PT28M').should('have.value', 'PT28M');

      cy.get(`[data-cy="durationRequiredTom"]`).type('PT9M').should('have.value', 'PT9M');

      cy.get(`[data-cy="booleanTom"]`).should('not.be.checked');
      cy.get(`[data-cy="booleanTom"]`).click().should('be.checked');

      cy.get(`[data-cy="booleanRequiredTom"]`).should('not.be.checked');
      cy.get(`[data-cy="booleanRequiredTom"]`).click().should('be.checked');

      cy.get(`[data-cy="enumTom"]`).select('ENUM_VALUE_3');

      cy.get(`[data-cy="enumRequiredTom"]`).select('ENUM_VALUE_3');

      cy.get(`[data-cy="uuidTom"]`)
        .type('34b4d2e9-e7ca-47e2-9745-212f677d71b7')
        .invoke('val')
        .should('match', new RegExp('34b4d2e9-e7ca-47e2-9745-212f677d71b7'));

      cy.get(`[data-cy="uuidRequiredTom"]`)
        .type('661a4c28-3fb3-4236-ba38-ef7602b2fc57')
        .invoke('val')
        .should('match', new RegExp('661a4c28-3fb3-4236-ba38-ef7602b2fc57'));

      cy.setFieldImageAsBytesOfEntity('byteImageTom', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteImageRequiredTom', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteImageMinbytesTom', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteImageMaxbytesTom', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteAnyTom', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteAnyRequiredTom', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteAnyMinbytesTom', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteAnyMaxbytesTom', 'integration-test.png', 'image/png');

      cy.get(`[data-cy="byteTextTom"]`)
        .type('../fake-data/blob/hipster.txt')
        .invoke('val')
        .should('match', new RegExp('../fake-data/blob/hipster.txt'));

      cy.get(`[data-cy="byteTextRequiredTom"]`)
        .type('../fake-data/blob/hipster.txt')
        .invoke('val')
        .should('match', new RegExp('../fake-data/blob/hipster.txt'));

      // since cypress clicks submit too fast before the blob fields are validated
      cy.wait(200); // eslint-disable-line cypress/no-unnecessary-waiting
      cy.get(entityCreateSaveButtonSelector).click();

      cy.wait('@postEntityRequest').then(({ response }) => {
        expect(response!.statusCode).to.equal(201);
        fieldTestEntity = response!.body;
      });
      cy.wait('@entitiesRequest').then(({ response }) => {
        expect(response!.statusCode).to.equal(200);
      });
      cy.url().should('match', fieldTestEntityPageUrlPattern);
    });
  });
});
