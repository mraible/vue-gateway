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

describe('EntityWithServiceClassAndPagination e2e test', () => {
  const entityWithServiceClassAndPaginationPageUrl = '/entity-with-service-class-and-pagination';
  const entityWithServiceClassAndPaginationPageUrlPattern = new RegExp('/entity-with-service-class-and-pagination(\\?.*)?$');
  const username = Cypress.env('E2E_USERNAME') ?? 'admin';
  const password = Cypress.env('E2E_PASSWORD') ?? 'admin';
  const entityWithServiceClassAndPaginationSample = { enzo: 'Account' };

  let entityWithServiceClassAndPagination: any;

  before(() => {
    cy.window().then(win => {
      win.sessionStorage.clear();
    });
    cy.visit('');
    cy.login(username, password);
    cy.get(entityItemSelector).should('exist');
  });

  beforeEach(() => {
    cy.intercept('GET', '/api/entity-with-service-class-and-paginations+(?*|)').as('entitiesRequest');
    cy.intercept('POST', '/api/entity-with-service-class-and-paginations').as('postEntityRequest');
    cy.intercept('DELETE', '/api/entity-with-service-class-and-paginations/*').as('deleteEntityRequest');
  });

  afterEach(() => {
    if (entityWithServiceClassAndPagination) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/entity-with-service-class-and-paginations/${entityWithServiceClassAndPagination.id}`,
      }).then(() => {
        entityWithServiceClassAndPagination = undefined;
      });
    }
  });

  it('EntityWithServiceClassAndPaginations menu should load EntityWithServiceClassAndPaginations page', () => {
    cy.visit('/');
    cy.clickOnEntityMenuItem('entity-with-service-class-and-pagination');
    cy.wait('@entitiesRequest').then(({ response }) => {
      if (response!.body.length === 0) {
        cy.get(entityTableSelector).should('not.exist');
      } else {
        cy.get(entityTableSelector).should('exist');
      }
    });
    cy.getEntityHeading('EntityWithServiceClassAndPagination').should('exist');
    cy.url().should('match', entityWithServiceClassAndPaginationPageUrlPattern);
  });

  describe('EntityWithServiceClassAndPagination page', () => {
    describe('create button click', () => {
      beforeEach(() => {
        cy.visit(entityWithServiceClassAndPaginationPageUrl);
        cy.wait('@entitiesRequest');
      });

      it('should load create EntityWithServiceClassAndPagination page', () => {
        cy.get(entityCreateButtonSelector).click({ force: true });
        cy.url().should('match', new RegExp('/entity-with-service-class-and-pagination/new$'));
        cy.getEntityCreateUpdateHeading('EntityWithServiceClassAndPagination');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', entityWithServiceClassAndPaginationPageUrlPattern);
      });
    });

    describe('with existing value', () => {
      beforeEach(() => {
        cy.authenticatedRequest({
          method: 'POST',
          url: '/api/entity-with-service-class-and-paginations',
          body: entityWithServiceClassAndPaginationSample,
        }).then(({ body }) => {
          entityWithServiceClassAndPagination = body;

          cy.intercept(
            {
              method: 'GET',
              url: '/api/entity-with-service-class-and-paginations+(?*|)',
              times: 1,
            },
            {
              statusCode: 200,
              headers: {
                link: '<http://localhost/api/entity-with-service-class-and-paginations?page=0&size=20>; rel="last",<http://localhost/api/entity-with-service-class-and-paginations?page=0&size=20>; rel="first"',
              },
              body: [entityWithServiceClassAndPagination],
            }
          ).as('entitiesRequestInternal');
        });

        cy.visit(entityWithServiceClassAndPaginationPageUrl);

        cy.wait('@entitiesRequestInternal');
      });

      it('detail button click should load details EntityWithServiceClassAndPagination page', () => {
        cy.get(entityDetailsButtonSelector).first().click();
        cy.getEntityDetailsHeading('entityWithServiceClassAndPagination');
        cy.get(entityDetailsBackButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', entityWithServiceClassAndPaginationPageUrlPattern);
      });

      it('edit button click should load edit EntityWithServiceClassAndPagination page', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('EntityWithServiceClassAndPagination');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', entityWithServiceClassAndPaginationPageUrlPattern);
      });

      it('last delete button click should delete instance of EntityWithServiceClassAndPagination', () => {
        cy.get(entityDeleteButtonSelector).last().click();
        cy.getEntityDeleteDialogHeading('entityWithServiceClassAndPagination').should('exist');
        cy.get(entityConfirmDeleteButtonSelector).click({ force: true });
        cy.wait('@deleteEntityRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(204);
        });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', entityWithServiceClassAndPaginationPageUrlPattern);

        entityWithServiceClassAndPagination = undefined;
      });
    });
  });

  describe('new EntityWithServiceClassAndPagination page', () => {
    beforeEach(() => {
      cy.visit(`${entityWithServiceClassAndPaginationPageUrl}`);
      cy.get(entityCreateButtonSelector).click({ force: true });
      cy.getEntityCreateUpdateHeading('EntityWithServiceClassAndPagination');
    });

    it('should create an instance of EntityWithServiceClassAndPagination', () => {
      cy.get(`[data-cy="enzo"]`).type('enable Human New').should('have.value', 'enable Human New');

      cy.get(entityCreateSaveButtonSelector).click();

      cy.wait('@postEntityRequest').then(({ response }) => {
        expect(response!.statusCode).to.equal(201);
        entityWithServiceClassAndPagination = response!.body;
      });
      cy.wait('@entitiesRequest').then(({ response }) => {
        expect(response!.statusCode).to.equal(200);
      });
      cy.url().should('match', entityWithServiceClassAndPaginationPageUrlPattern);
    });
  });
});
