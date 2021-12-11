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

describe('FieldTestMapstructAndServiceClassEntity e2e test', () => {
  const fieldTestMapstructAndServiceClassEntityPageUrl = '/field-test-mapstruct-and-service-class-entity';
  const fieldTestMapstructAndServiceClassEntityPageUrlPattern = new RegExp('/field-test-mapstruct-and-service-class-entity(\\?.*)?$');
  const username = Cypress.env('E2E_USERNAME') ?? 'admin';
  const password = Cypress.env('E2E_PASSWORD') ?? 'admin';
  const fieldTestMapstructAndServiceClassEntitySample = {
    stringRequiredEva: 'Cambridgeshire info-mediaries Implementation',
    integerRequiredEva: 78351,
    longRequiredEva: 94531,
    floatRequiredEva: 56464,
    doubleRequiredEva: 48210,
    bigDecimalRequiredEva: 34028,
    localDateRequiredEva: '2016-02-08',
    instanteRequiredEva: '2016-02-08T14:58:45.867Z',
    zonedDateTimeRequiredEva: '2016-02-07T21:57:01.534Z',
    durationRequiredEva: 42479,
    booleanRequiredEva: true,
    enumRequiredEva: 'ENUM_VALUE_2',
    uuidRequiredEva: 'bf771093-e204-4fd6-a693-f18fd9338cfa',
    byteImageRequiredEva: 'Li4vZmFrZS1kYXRhL2Jsb2IvaGlwc3Rlci5wbmc=',
    byteImageRequiredEvaContentType: 'unknown',
    byteAnyRequiredEva: 'Li4vZmFrZS1kYXRhL2Jsb2IvaGlwc3Rlci5wbmc=',
    byteAnyRequiredEvaContentType: 'unknown',
    byteTextRequiredEva: 'Li4vZmFrZS1kYXRhL2Jsb2IvaGlwc3Rlci50eHQ=',
  };

  let fieldTestMapstructAndServiceClassEntity: any;

  before(() => {
    cy.window().then(win => {
      win.sessionStorage.clear();
    });
    cy.visit('');
    cy.login(username, password);
    cy.get(entityItemSelector).should('exist');
  });

  beforeEach(() => {
    cy.intercept('GET', '/api/field-test-mapstruct-and-service-class-entities+(?*|)').as('entitiesRequest');
    cy.intercept('POST', '/api/field-test-mapstruct-and-service-class-entities').as('postEntityRequest');
    cy.intercept('DELETE', '/api/field-test-mapstruct-and-service-class-entities/*').as('deleteEntityRequest');
  });

  afterEach(() => {
    if (fieldTestMapstructAndServiceClassEntity) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/field-test-mapstruct-and-service-class-entities/${fieldTestMapstructAndServiceClassEntity.id}`,
      }).then(() => {
        fieldTestMapstructAndServiceClassEntity = undefined;
      });
    }
  });

  it('FieldTestMapstructAndServiceClassEntities menu should load FieldTestMapstructAndServiceClassEntities page', () => {
    cy.visit('/');
    cy.clickOnEntityMenuItem('field-test-mapstruct-and-service-class-entity');
    cy.wait('@entitiesRequest').then(({ response }) => {
      if (response!.body.length === 0) {
        cy.get(entityTableSelector).should('not.exist');
      } else {
        cy.get(entityTableSelector).should('exist');
      }
    });
    cy.getEntityHeading('FieldTestMapstructAndServiceClassEntity').should('exist');
    cy.url().should('match', fieldTestMapstructAndServiceClassEntityPageUrlPattern);
  });

  describe('FieldTestMapstructAndServiceClassEntity page', () => {
    describe('create button click', () => {
      beforeEach(() => {
        cy.visit(fieldTestMapstructAndServiceClassEntityPageUrl);
        cy.wait('@entitiesRequest');
      });

      it('should load create FieldTestMapstructAndServiceClassEntity page', () => {
        cy.get(entityCreateButtonSelector).click({ force: true });
        cy.url().should('match', new RegExp('/field-test-mapstruct-and-service-class-entity/new$'));
        cy.getEntityCreateUpdateHeading('FieldTestMapstructAndServiceClassEntity');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', fieldTestMapstructAndServiceClassEntityPageUrlPattern);
      });
    });

    describe('with existing value', () => {
      beforeEach(() => {
        cy.authenticatedRequest({
          method: 'POST',
          url: '/api/field-test-mapstruct-and-service-class-entities',
          body: fieldTestMapstructAndServiceClassEntitySample,
        }).then(({ body }) => {
          fieldTestMapstructAndServiceClassEntity = body;

          cy.intercept(
            {
              method: 'GET',
              url: '/api/field-test-mapstruct-and-service-class-entities+(?*|)',
              times: 1,
            },
            {
              statusCode: 200,
              body: [fieldTestMapstructAndServiceClassEntity],
            }
          ).as('entitiesRequestInternal');
        });

        cy.visit(fieldTestMapstructAndServiceClassEntityPageUrl);

        cy.wait('@entitiesRequestInternal');
      });

      it('detail button click should load details FieldTestMapstructAndServiceClassEntity page', () => {
        cy.get(entityDetailsButtonSelector).first().click();
        cy.getEntityDetailsHeading('fieldTestMapstructAndServiceClassEntity');
        cy.get(entityDetailsBackButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', fieldTestMapstructAndServiceClassEntityPageUrlPattern);
      });

      it('edit button click should load edit FieldTestMapstructAndServiceClassEntity page', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('FieldTestMapstructAndServiceClassEntity');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', fieldTestMapstructAndServiceClassEntityPageUrlPattern);
      });

      it('last delete button click should delete instance of FieldTestMapstructAndServiceClassEntity', () => {
        cy.get(entityDeleteButtonSelector).last().click();
        cy.getEntityDeleteDialogHeading('fieldTestMapstructAndServiceClassEntity').should('exist');
        cy.get(entityConfirmDeleteButtonSelector).click({ force: true });
        cy.wait('@deleteEntityRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(204);
        });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', fieldTestMapstructAndServiceClassEntityPageUrlPattern);

        fieldTestMapstructAndServiceClassEntity = undefined;
      });
    });
  });

  describe('new FieldTestMapstructAndServiceClassEntity page', () => {
    beforeEach(() => {
      cy.visit(`${fieldTestMapstructAndServiceClassEntityPageUrl}`);
      cy.get(entityCreateButtonSelector).click({ force: true });
      cy.getEntityCreateUpdateHeading('FieldTestMapstructAndServiceClassEntity');
    });

    it('should create an instance of FieldTestMapstructAndServiceClassEntity', () => {
      cy.get(`[data-cy="stringEva"]`).type('Dollar Organic eyeballs').should('have.value', 'Dollar Organic eyeballs');

      cy.get(`[data-cy="stringRequiredEva"]`).type('Kids').should('have.value', 'Kids');

      cy.get(`[data-cy="stringMinlengthEva"]`).type('Analyst Practical Borders').should('have.value', 'Analyst Practical Borders');

      cy.get(`[data-cy="stringMaxlengthEva"]`).type('EXE').should('have.value', 'EXE');

      cy.get(`[data-cy="stringPatternEva"]`).type('mYG').should('have.value', 'mYG');

      cy.get(`[data-cy="integerEva"]`).type('95105').should('have.value', '95105');

      cy.get(`[data-cy="integerRequiredEva"]`).type('45525').should('have.value', '45525');

      cy.get(`[data-cy="integerMinEva"]`).type('75187').should('have.value', '75187');

      cy.get(`[data-cy="integerMaxEva"]`).type('79').should('have.value', '79');

      cy.get(`[data-cy="longEva"]`).type('83069').should('have.value', '83069');

      cy.get(`[data-cy="longRequiredEva"]`).type('78313').should('have.value', '78313');

      cy.get(`[data-cy="longMinEva"]`).type('83182').should('have.value', '83182');

      cy.get(`[data-cy="longMaxEva"]`).type('26').should('have.value', '26');

      cy.get(`[data-cy="floatEva"]`).type('78188').should('have.value', '78188');

      cy.get(`[data-cy="floatRequiredEva"]`).type('1236').should('have.value', '1236');

      cy.get(`[data-cy="floatMinEva"]`).type('48278').should('have.value', '48278');

      cy.get(`[data-cy="floatMaxEva"]`).type('65').should('have.value', '65');

      cy.get(`[data-cy="doubleRequiredEva"]`).type('90765').should('have.value', '90765');

      cy.get(`[data-cy="doubleMinEva"]`).type('76059').should('have.value', '76059');

      cy.get(`[data-cy="doubleMaxEva"]`).type('84').should('have.value', '84');

      cy.get(`[data-cy="bigDecimalRequiredEva"]`).type('133').should('have.value', '133');

      cy.get(`[data-cy="bigDecimalMinEva"]`).type('49075').should('have.value', '49075');

      cy.get(`[data-cy="bigDecimalMaxEva"]`).type('96').should('have.value', '96');

      cy.get(`[data-cy="localDateEva"]`).type('2016-02-07').should('have.value', '2016-02-07');

      cy.get(`[data-cy="localDateRequiredEva"]`).type('2016-02-08').should('have.value', '2016-02-08');

      cy.get(`[data-cy="instantEva"]`).type('2016-02-08T16:10').should('have.value', '2016-02-08T16:10');

      cy.get(`[data-cy="instanteRequiredEva"]`).type('2016-02-08T02:19').should('have.value', '2016-02-08T02:19');

      cy.get(`[data-cy="zonedDateTimeEva"]`).type('2016-02-08T09:46').should('have.value', '2016-02-08T09:46');

      cy.get(`[data-cy="zonedDateTimeRequiredEva"]`).type('2016-02-08T13:50').should('have.value', '2016-02-08T13:50');

      cy.get(`[data-cy="durationEva"]`).type('PT10M').should('have.value', 'PT10M');

      cy.get(`[data-cy="durationRequiredEva"]`).type('PT33M').should('have.value', 'PT33M');

      cy.get(`[data-cy="booleanEva"]`).should('not.be.checked');
      cy.get(`[data-cy="booleanEva"]`).click().should('be.checked');

      cy.get(`[data-cy="booleanRequiredEva"]`).should('not.be.checked');
      cy.get(`[data-cy="booleanRequiredEva"]`).click().should('be.checked');

      cy.get(`[data-cy="enumEva"]`).select('ENUM_VALUE_2');

      cy.get(`[data-cy="enumRequiredEva"]`).select('ENUM_VALUE_1');

      cy.get(`[data-cy="uuidEva"]`)
        .type('30f9792d-6d07-44f0-abbc-c86398cf5beb')
        .invoke('val')
        .should('match', new RegExp('30f9792d-6d07-44f0-abbc-c86398cf5beb'));

      cy.get(`[data-cy="uuidRequiredEva"]`)
        .type('cee50bc0-97d6-49c2-8917-9220f782adb6')
        .invoke('val')
        .should('match', new RegExp('cee50bc0-97d6-49c2-8917-9220f782adb6'));

      cy.setFieldImageAsBytesOfEntity('byteImageEva', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteImageRequiredEva', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteImageMinbytesEva', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteImageMaxbytesEva', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteAnyEva', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteAnyRequiredEva', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteAnyMinbytesEva', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteAnyMaxbytesEva', 'integration-test.png', 'image/png');

      cy.get(`[data-cy="byteTextEva"]`)
        .type('../fake-data/blob/hipster.txt')
        .invoke('val')
        .should('match', new RegExp('../fake-data/blob/hipster.txt'));

      cy.get(`[data-cy="byteTextRequiredEva"]`)
        .type('../fake-data/blob/hipster.txt')
        .invoke('val')
        .should('match', new RegExp('../fake-data/blob/hipster.txt'));

      // since cypress clicks submit too fast before the blob fields are validated
      cy.wait(200); // eslint-disable-line cypress/no-unnecessary-waiting
      cy.get(entityCreateSaveButtonSelector).click();

      cy.wait('@postEntityRequest').then(({ response }) => {
        expect(response!.statusCode).to.equal(201);
        fieldTestMapstructAndServiceClassEntity = response!.body;
      });
      cy.wait('@entitiesRequest').then(({ response }) => {
        expect(response!.statusCode).to.equal(200);
      });
      cy.url().should('match', fieldTestMapstructAndServiceClassEntityPageUrlPattern);
    });
  });
});
