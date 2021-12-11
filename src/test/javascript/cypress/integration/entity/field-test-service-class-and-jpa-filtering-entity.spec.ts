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

describe('FieldTestServiceClassAndJpaFilteringEntity e2e test', () => {
  const fieldTestServiceClassAndJpaFilteringEntityPageUrl = '/field-test-service-class-and-jpa-filtering-entity';
  const fieldTestServiceClassAndJpaFilteringEntityPageUrlPattern = new RegExp(
    '/field-test-service-class-and-jpa-filtering-entity(\\?.*)?$'
  );
  const username = Cypress.env('E2E_USERNAME') ?? 'admin';
  const password = Cypress.env('E2E_PASSWORD') ?? 'admin';
  const fieldTestServiceClassAndJpaFilteringEntitySample = {
    stringRequiredBob: 'Berkshire grid-enabled Kina',
    integerRequiredBob: 29,
    longRequiredBob: 3126,
    floatRequiredBob: 14378,
    doubleRequiredBob: 71269,
    bigDecimalRequiredBob: 60134,
    localDateRequiredBob: '2016-02-07',
    instanteRequiredBob: '2016-02-08T15:24:33.857Z',
    zonedDateTimeRequiredBob: '2016-02-08T12:02:52.404Z',
    durationRequiredBob: 25743,
    booleanRequiredBob: true,
    enumRequiredBob: 'ENUM_VALUE_2',
    uuidRequiredBob: 'f3c04986-dc11-42c0-a9ee-5b58a7a47d01',
    byteImageRequiredBob: 'Li4vZmFrZS1kYXRhL2Jsb2IvaGlwc3Rlci5wbmc=',
    byteImageRequiredBobContentType: 'unknown',
    byteAnyRequiredBob: 'Li4vZmFrZS1kYXRhL2Jsb2IvaGlwc3Rlci5wbmc=',
    byteAnyRequiredBobContentType: 'unknown',
    byteTextRequiredBob: 'Li4vZmFrZS1kYXRhL2Jsb2IvaGlwc3Rlci50eHQ=',
  };

  let fieldTestServiceClassAndJpaFilteringEntity: any;

  before(() => {
    cy.window().then(win => {
      win.sessionStorage.clear();
    });
    cy.visit('');
    cy.login(username, password);
    cy.get(entityItemSelector).should('exist');
  });

  beforeEach(() => {
    cy.intercept('GET', '/api/field-test-service-class-and-jpa-filtering-entities+(?*|)').as('entitiesRequest');
    cy.intercept('POST', '/api/field-test-service-class-and-jpa-filtering-entities').as('postEntityRequest');
    cy.intercept('DELETE', '/api/field-test-service-class-and-jpa-filtering-entities/*').as('deleteEntityRequest');
  });

  afterEach(() => {
    if (fieldTestServiceClassAndJpaFilteringEntity) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/field-test-service-class-and-jpa-filtering-entities/${fieldTestServiceClassAndJpaFilteringEntity.id}`,
      }).then(() => {
        fieldTestServiceClassAndJpaFilteringEntity = undefined;
      });
    }
  });

  it('FieldTestServiceClassAndJpaFilteringEntities menu should load FieldTestServiceClassAndJpaFilteringEntities page', () => {
    cy.visit('/');
    cy.clickOnEntityMenuItem('field-test-service-class-and-jpa-filtering-entity');
    cy.wait('@entitiesRequest').then(({ response }) => {
      if (response!.body.length === 0) {
        cy.get(entityTableSelector).should('not.exist');
      } else {
        cy.get(entityTableSelector).should('exist');
      }
    });
    cy.getEntityHeading('FieldTestServiceClassAndJpaFilteringEntity').should('exist');
    cy.url().should('match', fieldTestServiceClassAndJpaFilteringEntityPageUrlPattern);
  });

  describe('FieldTestServiceClassAndJpaFilteringEntity page', () => {
    describe('create button click', () => {
      beforeEach(() => {
        cy.visit(fieldTestServiceClassAndJpaFilteringEntityPageUrl);
        cy.wait('@entitiesRequest');
      });

      it('should load create FieldTestServiceClassAndJpaFilteringEntity page', () => {
        cy.get(entityCreateButtonSelector).click({ force: true });
        cy.url().should('match', new RegExp('/field-test-service-class-and-jpa-filtering-entity/new$'));
        cy.getEntityCreateUpdateHeading('FieldTestServiceClassAndJpaFilteringEntity');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', fieldTestServiceClassAndJpaFilteringEntityPageUrlPattern);
      });
    });

    describe('with existing value', () => {
      beforeEach(() => {
        cy.authenticatedRequest({
          method: 'POST',
          url: '/api/field-test-service-class-and-jpa-filtering-entities',
          body: fieldTestServiceClassAndJpaFilteringEntitySample,
        }).then(({ body }) => {
          fieldTestServiceClassAndJpaFilteringEntity = body;

          cy.intercept(
            {
              method: 'GET',
              url: '/api/field-test-service-class-and-jpa-filtering-entities+(?*|)',
              times: 1,
            },
            {
              statusCode: 200,
              body: [fieldTestServiceClassAndJpaFilteringEntity],
            }
          ).as('entitiesRequestInternal');
        });

        cy.visit(fieldTestServiceClassAndJpaFilteringEntityPageUrl);

        cy.wait('@entitiesRequestInternal');
      });

      it('detail button click should load details FieldTestServiceClassAndJpaFilteringEntity page', () => {
        cy.get(entityDetailsButtonSelector).first().click();
        cy.getEntityDetailsHeading('fieldTestServiceClassAndJpaFilteringEntity');
        cy.get(entityDetailsBackButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', fieldTestServiceClassAndJpaFilteringEntityPageUrlPattern);
      });

      it('edit button click should load edit FieldTestServiceClassAndJpaFilteringEntity page', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('FieldTestServiceClassAndJpaFilteringEntity');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', fieldTestServiceClassAndJpaFilteringEntityPageUrlPattern);
      });

      it('last delete button click should delete instance of FieldTestServiceClassAndJpaFilteringEntity', () => {
        cy.get(entityDeleteButtonSelector).last().click();
        cy.getEntityDeleteDialogHeading('fieldTestServiceClassAndJpaFilteringEntity').should('exist');
        cy.get(entityConfirmDeleteButtonSelector).click({ force: true });
        cy.wait('@deleteEntityRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(204);
        });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', fieldTestServiceClassAndJpaFilteringEntityPageUrlPattern);

        fieldTestServiceClassAndJpaFilteringEntity = undefined;
      });
    });
  });

  describe('new FieldTestServiceClassAndJpaFilteringEntity page', () => {
    beforeEach(() => {
      cy.visit(`${fieldTestServiceClassAndJpaFilteringEntityPageUrl}`);
      cy.get(entityCreateButtonSelector).click({ force: true });
      cy.getEntityCreateUpdateHeading('FieldTestServiceClassAndJpaFilteringEntity');
    });

    it('should create an instance of FieldTestServiceClassAndJpaFilteringEntity', () => {
      cy.get(`[data-cy="stringBob"]`).type('Sahara').should('have.value', 'Sahara');

      cy.get(`[data-cy="stringRequiredBob"]`).type('Toys Viaduct mindshare').should('have.value', 'Toys Viaduct mindshare');

      cy.get(`[data-cy="stringMinlengthBob"]`).type('definition').should('have.value', 'definition');

      cy.get(`[data-cy="stringMaxlengthBob"]`).type('and array').should('have.value', 'and array');

      cy.get(`[data-cy="stringPatternBob"]`).type('o').should('have.value', 'o');

      cy.get(`[data-cy="integerBob"]`).type('85678').should('have.value', '85678');

      cy.get(`[data-cy="integerRequiredBob"]`).type('46790').should('have.value', '46790');

      cy.get(`[data-cy="integerMinBob"]`).type('38904').should('have.value', '38904');

      cy.get(`[data-cy="integerMaxBob"]`).type('67').should('have.value', '67');

      cy.get(`[data-cy="longBob"]`).type('96790').should('have.value', '96790');

      cy.get(`[data-cy="longRequiredBob"]`).type('49529').should('have.value', '49529');

      cy.get(`[data-cy="longMinBob"]`).type('17541').should('have.value', '17541');

      cy.get(`[data-cy="longMaxBob"]`).type('33').should('have.value', '33');

      cy.get(`[data-cy="floatBob"]`).type('35406').should('have.value', '35406');

      cy.get(`[data-cy="floatRequiredBob"]`).type('10008').should('have.value', '10008');

      cy.get(`[data-cy="floatMinBob"]`).type('59886').should('have.value', '59886');

      cy.get(`[data-cy="floatMaxBob"]`).type('19').should('have.value', '19');

      cy.get(`[data-cy="doubleRequiredBob"]`).type('44895').should('have.value', '44895');

      cy.get(`[data-cy="doubleMinBob"]`).type('78617').should('have.value', '78617');

      cy.get(`[data-cy="doubleMaxBob"]`).type('79').should('have.value', '79');

      cy.get(`[data-cy="bigDecimalRequiredBob"]`).type('54091').should('have.value', '54091');

      cy.get(`[data-cy="bigDecimalMinBob"]`).type('76721').should('have.value', '76721');

      cy.get(`[data-cy="bigDecimalMaxBob"]`).type('60').should('have.value', '60');

      cy.get(`[data-cy="localDateBob"]`).type('2016-02-07').should('have.value', '2016-02-07');

      cy.get(`[data-cy="localDateRequiredBob"]`).type('2016-02-08').should('have.value', '2016-02-08');

      cy.get(`[data-cy="instantBob"]`).type('2016-02-08T12:37').should('have.value', '2016-02-08T12:37');

      cy.get(`[data-cy="instanteRequiredBob"]`).type('2016-02-07T23:08').should('have.value', '2016-02-07T23:08');

      cy.get(`[data-cy="zonedDateTimeBob"]`).type('2016-02-08T16:17').should('have.value', '2016-02-08T16:17');

      cy.get(`[data-cy="zonedDateTimeRequiredBob"]`).type('2016-02-07T21:56').should('have.value', '2016-02-07T21:56');

      cy.get(`[data-cy="durationBob"]`).type('PT32M').should('have.value', 'PT32M');

      cy.get(`[data-cy="durationRequiredBob"]`).type('PT3M').should('have.value', 'PT3M');

      cy.get(`[data-cy="booleanBob"]`).should('not.be.checked');
      cy.get(`[data-cy="booleanBob"]`).click().should('be.checked');

      cy.get(`[data-cy="booleanRequiredBob"]`).should('not.be.checked');
      cy.get(`[data-cy="booleanRequiredBob"]`).click().should('be.checked');

      cy.get(`[data-cy="enumBob"]`).select('ENUM_VALUE_3');

      cy.get(`[data-cy="enumRequiredBob"]`).select('ENUM_VALUE_3');

      cy.get(`[data-cy="uuidBob"]`)
        .type('f2aee855-13f9-4236-bf84-017f52cfd1b4')
        .invoke('val')
        .should('match', new RegExp('f2aee855-13f9-4236-bf84-017f52cfd1b4'));

      cy.get(`[data-cy="uuidRequiredBob"]`)
        .type('d28c4ad6-0cb0-4685-8712-8ee9dc173685')
        .invoke('val')
        .should('match', new RegExp('d28c4ad6-0cb0-4685-8712-8ee9dc173685'));

      cy.setFieldImageAsBytesOfEntity('byteImageBob', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteImageRequiredBob', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteImageMinbytesBob', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteImageMaxbytesBob', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteAnyBob', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteAnyRequiredBob', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteAnyMinbytesBob', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteAnyMaxbytesBob', 'integration-test.png', 'image/png');

      cy.get(`[data-cy="byteTextBob"]`)
        .type('../fake-data/blob/hipster.txt')
        .invoke('val')
        .should('match', new RegExp('../fake-data/blob/hipster.txt'));

      cy.get(`[data-cy="byteTextRequiredBob"]`)
        .type('../fake-data/blob/hipster.txt')
        .invoke('val')
        .should('match', new RegExp('../fake-data/blob/hipster.txt'));

      // since cypress clicks submit too fast before the blob fields are validated
      cy.wait(200); // eslint-disable-line cypress/no-unnecessary-waiting
      cy.get(entityCreateSaveButtonSelector).click();

      cy.wait('@postEntityRequest').then(({ response }) => {
        expect(response!.statusCode).to.equal(201);
        fieldTestServiceClassAndJpaFilteringEntity = response!.body;
      });
      cy.wait('@entitiesRequest').then(({ response }) => {
        expect(response!.statusCode).to.equal(200);
      });
      cy.url().should('match', fieldTestServiceClassAndJpaFilteringEntityPageUrlPattern);
    });
  });
});
