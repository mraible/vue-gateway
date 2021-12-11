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

describe('FieldTestInfiniteScrollEntity e2e test', () => {
  const fieldTestInfiniteScrollEntityPageUrl = '/field-test-infinite-scroll-entity';
  const fieldTestInfiniteScrollEntityPageUrlPattern = new RegExp('/field-test-infinite-scroll-entity(\\?.*)?$');
  const username = Cypress.env('E2E_USERNAME') ?? 'admin';
  const password = Cypress.env('E2E_PASSWORD') ?? 'admin';
  const fieldTestInfiniteScrollEntitySample = {
    stringRequiredHugo: 'payment',
    integerRequiredHugo: 97994,
    longRequiredHugo: 56111,
    floatRequiredHugo: 27055,
    doubleRequiredHugo: 12396,
    bigDecimalRequiredHugo: 77448,
    localDateRequiredHugo: '2016-02-08',
    instanteRequiredHugo: '2016-02-08T06:09:55.748Z',
    zonedDateTimeRequiredHugo: '2016-02-07T21:11:58.034Z',
    durationRequiredHugo: 81678,
    booleanRequiredHugo: false,
    enumRequiredHugo: 'ENUM_VALUE_3',
    uuidRequiredHugo: '8b8d7034-53ca-4744-bde0-164d26b16b55',
    byteImageRequiredHugo: 'Li4vZmFrZS1kYXRhL2Jsb2IvaGlwc3Rlci5wbmc=',
    byteImageRequiredHugoContentType: 'unknown',
    byteAnyRequiredHugo: 'Li4vZmFrZS1kYXRhL2Jsb2IvaGlwc3Rlci5wbmc=',
    byteAnyRequiredHugoContentType: 'unknown',
    byteTextRequiredHugo: 'Li4vZmFrZS1kYXRhL2Jsb2IvaGlwc3Rlci50eHQ=',
  };

  let fieldTestInfiniteScrollEntity: any;

  before(() => {
    cy.window().then(win => {
      win.sessionStorage.clear();
    });
    cy.visit('');
    cy.login(username, password);
    cy.get(entityItemSelector).should('exist');
  });

  beforeEach(() => {
    cy.intercept('GET', '/api/field-test-infinite-scroll-entities+(?*|)').as('entitiesRequest');
    cy.intercept('POST', '/api/field-test-infinite-scroll-entities').as('postEntityRequest');
    cy.intercept('DELETE', '/api/field-test-infinite-scroll-entities/*').as('deleteEntityRequest');
  });

  afterEach(() => {
    if (fieldTestInfiniteScrollEntity) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/field-test-infinite-scroll-entities/${fieldTestInfiniteScrollEntity.id}`,
      }).then(() => {
        fieldTestInfiniteScrollEntity = undefined;
      });
    }
  });

  it('FieldTestInfiniteScrollEntities menu should load FieldTestInfiniteScrollEntities page', () => {
    cy.visit('/');
    cy.clickOnEntityMenuItem('field-test-infinite-scroll-entity');
    cy.wait('@entitiesRequest').then(({ response }) => {
      if (response!.body.length === 0) {
        cy.get(entityTableSelector).should('not.exist');
      } else {
        cy.get(entityTableSelector).should('exist');
      }
    });
    cy.getEntityHeading('FieldTestInfiniteScrollEntity').should('exist');
    cy.url().should('match', fieldTestInfiniteScrollEntityPageUrlPattern);
  });

  describe('FieldTestInfiniteScrollEntity page', () => {
    describe('create button click', () => {
      beforeEach(() => {
        cy.visit(fieldTestInfiniteScrollEntityPageUrl);
        cy.wait('@entitiesRequest');
      });

      it('should load create FieldTestInfiniteScrollEntity page', () => {
        cy.get(entityCreateButtonSelector).click({ force: true });
        cy.url().should('match', new RegExp('/field-test-infinite-scroll-entity/new$'));
        cy.getEntityCreateUpdateHeading('FieldTestInfiniteScrollEntity');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', fieldTestInfiniteScrollEntityPageUrlPattern);
      });
    });

    describe('with existing value', () => {
      beforeEach(() => {
        cy.authenticatedRequest({
          method: 'POST',
          url: '/api/field-test-infinite-scroll-entities',
          body: fieldTestInfiniteScrollEntitySample,
        }).then(({ body }) => {
          fieldTestInfiniteScrollEntity = body;

          cy.intercept(
            {
              method: 'GET',
              url: '/api/field-test-infinite-scroll-entities+(?*|)',
              times: 1,
            },
            {
              statusCode: 200,
              headers: {
                link: '<http://localhost/api/field-test-infinite-scroll-entities?page=0&size=20>; rel="last",<http://localhost/api/field-test-infinite-scroll-entities?page=0&size=20>; rel="first"',
              },
              body: [fieldTestInfiniteScrollEntity],
            }
          ).as('entitiesRequestInternal');
        });

        cy.visit(fieldTestInfiniteScrollEntityPageUrl);

        cy.wait('@entitiesRequestInternal');
      });

      it('detail button click should load details FieldTestInfiniteScrollEntity page', () => {
        cy.get(entityDetailsButtonSelector).first().click();
        cy.getEntityDetailsHeading('fieldTestInfiniteScrollEntity');
        cy.get(entityDetailsBackButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', fieldTestInfiniteScrollEntityPageUrlPattern);
      });

      it('edit button click should load edit FieldTestInfiniteScrollEntity page', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('FieldTestInfiniteScrollEntity');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', fieldTestInfiniteScrollEntityPageUrlPattern);
      });

      it('last delete button click should delete instance of FieldTestInfiniteScrollEntity', () => {
        cy.get(entityDeleteButtonSelector).last().click();
        cy.getEntityDeleteDialogHeading('fieldTestInfiniteScrollEntity').should('exist');
        cy.get(entityConfirmDeleteButtonSelector).click({ force: true });
        cy.wait('@deleteEntityRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(204);
        });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', fieldTestInfiniteScrollEntityPageUrlPattern);

        fieldTestInfiniteScrollEntity = undefined;
      });
    });
  });

  describe('new FieldTestInfiniteScrollEntity page', () => {
    beforeEach(() => {
      cy.visit(`${fieldTestInfiniteScrollEntityPageUrl}`);
      cy.get(entityCreateButtonSelector).click({ force: true });
      cy.getEntityCreateUpdateHeading('FieldTestInfiniteScrollEntity');
    });

    it('should create an instance of FieldTestInfiniteScrollEntity', () => {
      cy.get(`[data-cy="stringHugo"]`).type('CSS Rubber Accounts').should('have.value', 'CSS Rubber Accounts');

      cy.get(`[data-cy="stringRequiredHugo"]`).type('SMTP Delaware bi-directional').should('have.value', 'SMTP Delaware bi-directional');

      cy.get(`[data-cy="stringMinlengthHugo"]`).type('foreground').should('have.value', 'foreground');

      cy.get(`[data-cy="stringMaxlengthHugo"]`).type('blue Movies digital').should('have.value', 'blue Movies digital');

      cy.get(`[data-cy="stringPatternHugo"]`).type('IJ').should('have.value', 'IJ');

      cy.get(`[data-cy="integerHugo"]`).type('61534').should('have.value', '61534');

      cy.get(`[data-cy="integerRequiredHugo"]`).type('5661').should('have.value', '5661');

      cy.get(`[data-cy="integerMinHugo"]`).type('18148').should('have.value', '18148');

      cy.get(`[data-cy="integerMaxHugo"]`).type('27').should('have.value', '27');

      cy.get(`[data-cy="longHugo"]`).type('98332').should('have.value', '98332');

      cy.get(`[data-cy="longRequiredHugo"]`).type('955').should('have.value', '955');

      cy.get(`[data-cy="longMinHugo"]`).type('89355').should('have.value', '89355');

      cy.get(`[data-cy="longMaxHugo"]`).type('69').should('have.value', '69');

      cy.get(`[data-cy="floatHugo"]`).type('20230').should('have.value', '20230');

      cy.get(`[data-cy="floatRequiredHugo"]`).type('12723').should('have.value', '12723');

      cy.get(`[data-cy="floatMinHugo"]`).type('85860').should('have.value', '85860');

      cy.get(`[data-cy="floatMaxHugo"]`).type('55').should('have.value', '55');

      cy.get(`[data-cy="doubleRequiredHugo"]`).type('38680').should('have.value', '38680');

      cy.get(`[data-cy="doubleMinHugo"]`).type('50904').should('have.value', '50904');

      cy.get(`[data-cy="doubleMaxHugo"]`).type('74').should('have.value', '74');

      cy.get(`[data-cy="bigDecimalRequiredHugo"]`).type('78126').should('have.value', '78126');

      cy.get(`[data-cy="bigDecimalMinHugo"]`).type('64426').should('have.value', '64426');

      cy.get(`[data-cy="bigDecimalMaxHugo"]`).type('7').should('have.value', '7');

      cy.get(`[data-cy="localDateHugo"]`).type('2016-02-08').should('have.value', '2016-02-08');

      cy.get(`[data-cy="localDateRequiredHugo"]`).type('2016-02-08').should('have.value', '2016-02-08');

      cy.get(`[data-cy="instantHugo"]`).type('2016-02-07T19:41').should('have.value', '2016-02-07T19:41');

      cy.get(`[data-cy="instanteRequiredHugo"]`).type('2016-02-08T11:21').should('have.value', '2016-02-08T11:21');

      cy.get(`[data-cy="zonedDateTimeHugo"]`).type('2016-02-08T05:59').should('have.value', '2016-02-08T05:59');

      cy.get(`[data-cy="zonedDateTimeRequiredHugo"]`).type('2016-02-08T16:03').should('have.value', '2016-02-08T16:03');

      cy.get(`[data-cy="durationHugo"]`).type('PT30M').should('have.value', 'PT30M');

      cy.get(`[data-cy="durationRequiredHugo"]`).type('PT53M').should('have.value', 'PT53M');

      cy.get(`[data-cy="booleanHugo"]`).should('not.be.checked');
      cy.get(`[data-cy="booleanHugo"]`).click().should('be.checked');

      cy.get(`[data-cy="booleanRequiredHugo"]`).should('not.be.checked');
      cy.get(`[data-cy="booleanRequiredHugo"]`).click().should('be.checked');

      cy.get(`[data-cy="enumHugo"]`).select('ENUM_VALUE_2');

      cy.get(`[data-cy="enumRequiredHugo"]`).select('ENUM_VALUE_1');

      cy.get(`[data-cy="uuidHugo"]`)
        .type('41d525d3-4bc6-497c-862b-c75143f470e0')
        .invoke('val')
        .should('match', new RegExp('41d525d3-4bc6-497c-862b-c75143f470e0'));

      cy.get(`[data-cy="uuidRequiredHugo"]`)
        .type('8f58b984-1406-402a-8af1-ba5605ab6530')
        .invoke('val')
        .should('match', new RegExp('8f58b984-1406-402a-8af1-ba5605ab6530'));

      cy.setFieldImageAsBytesOfEntity('byteImageHugo', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteImageRequiredHugo', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteImageMinbytesHugo', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteImageMaxbytesHugo', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteAnyHugo', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteAnyRequiredHugo', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteAnyMinbytesHugo', 'integration-test.png', 'image/png');

      cy.setFieldImageAsBytesOfEntity('byteAnyMaxbytesHugo', 'integration-test.png', 'image/png');

      cy.get(`[data-cy="byteTextHugo"]`)
        .type('../fake-data/blob/hipster.txt')
        .invoke('val')
        .should('match', new RegExp('../fake-data/blob/hipster.txt'));

      cy.get(`[data-cy="byteTextRequiredHugo"]`)
        .type('../fake-data/blob/hipster.txt')
        .invoke('val')
        .should('match', new RegExp('../fake-data/blob/hipster.txt'));

      // since cypress clicks submit too fast before the blob fields are validated
      cy.wait(200); // eslint-disable-line cypress/no-unnecessary-waiting
      cy.get(entityCreateSaveButtonSelector).click();

      cy.wait('@postEntityRequest').then(({ response }) => {
        expect(response!.statusCode).to.equal(201);
        fieldTestInfiniteScrollEntity = response!.body;
      });
      cy.wait('@entitiesRequest').then(({ response }) => {
        expect(response!.statusCode).to.equal(200);
      });
      cy.url().should('match', fieldTestInfiniteScrollEntityPageUrlPattern);
    });
  });
});
