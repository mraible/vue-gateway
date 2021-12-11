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

describe('EntityWithServiceClassPaginationAndDTO e2e test', () => {
  const entityWithServiceClassPaginationAndDTOPageUrl = '/entity-with-service-class-pagination-and-dto';
  const entityWithServiceClassPaginationAndDTOPageUrlPattern = new RegExp('/entity-with-service-class-pagination-and-dto(\\?.*)?$');
  const username = Cypress.env('E2E_USERNAME') ?? 'admin';
  const password = Cypress.env('E2E_PASSWORD') ?? 'admin';
  const entityWithServiceClassPaginationAndDTOSample = { lena: 'ivory Wyoming SAS' };

  let entityWithServiceClassPaginationAndDTO: any;

  before(() => {
    cy.window().then(win => {
      win.sessionStorage.clear();
    });
    cy.visit('');
    cy.login(username, password);
    cy.get(entityItemSelector).should('exist');
  });

  beforeEach(() => {
    cy.intercept('GET', '/api/entity-with-service-class-pagination-and-dtos+(?*|)').as('entitiesRequest');
    cy.intercept('POST', '/api/entity-with-service-class-pagination-and-dtos').as('postEntityRequest');
    cy.intercept('DELETE', '/api/entity-with-service-class-pagination-and-dtos/*').as('deleteEntityRequest');
  });

  afterEach(() => {
    if (entityWithServiceClassPaginationAndDTO) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/entity-with-service-class-pagination-and-dtos/${entityWithServiceClassPaginationAndDTO.id}`,
      }).then(() => {
        entityWithServiceClassPaginationAndDTO = undefined;
      });
    }
  });

  it('EntityWithServiceClassPaginationAndDTOS menu should load EntityWithServiceClassPaginationAndDTOS page', () => {
    cy.visit('/');
    cy.clickOnEntityMenuItem('entity-with-service-class-pagination-and-dto');
    cy.wait('@entitiesRequest').then(({ response }) => {
      if (response!.body.length === 0) {
        cy.get(entityTableSelector).should('not.exist');
      } else {
        cy.get(entityTableSelector).should('exist');
      }
    });
    cy.getEntityHeading('EntityWithServiceClassPaginationAndDTO').should('exist');
    cy.url().should('match', entityWithServiceClassPaginationAndDTOPageUrlPattern);
  });

  describe('EntityWithServiceClassPaginationAndDTO page', () => {
    describe('create button click', () => {
      beforeEach(() => {
        cy.visit(entityWithServiceClassPaginationAndDTOPageUrl);
        cy.wait('@entitiesRequest');
      });

      it('should load create EntityWithServiceClassPaginationAndDTO page', () => {
        cy.get(entityCreateButtonSelector).click({ force: true });
        cy.url().should('match', new RegExp('/entity-with-service-class-pagination-and-dto/new$'));
        cy.getEntityCreateUpdateHeading('EntityWithServiceClassPaginationAndDTO');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', entityWithServiceClassPaginationAndDTOPageUrlPattern);
      });
    });

    describe('with existing value', () => {
      beforeEach(() => {
        cy.authenticatedRequest({
          method: 'POST',
          url: '/api/entity-with-service-class-pagination-and-dtos',
          body: entityWithServiceClassPaginationAndDTOSample,
        }).then(({ body }) => {
          entityWithServiceClassPaginationAndDTO = body;

          cy.intercept(
            {
              method: 'GET',
              url: '/api/entity-with-service-class-pagination-and-dtos+(?*|)',
              times: 1,
            },
            {
              statusCode: 200,
              headers: {
                link: '<http://localhost/api/entity-with-service-class-pagination-and-dtos?page=0&size=20>; rel="last",<http://localhost/api/entity-with-service-class-pagination-and-dtos?page=0&size=20>; rel="first"',
              },
              body: [entityWithServiceClassPaginationAndDTO],
            }
          ).as('entitiesRequestInternal');
        });

        cy.visit(entityWithServiceClassPaginationAndDTOPageUrl);

        cy.wait('@entitiesRequestInternal');
      });

      it('detail button click should load details EntityWithServiceClassPaginationAndDTO page', () => {
        cy.get(entityDetailsButtonSelector).first().click();
        cy.getEntityDetailsHeading('entityWithServiceClassPaginationAndDTO');
        cy.get(entityDetailsBackButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', entityWithServiceClassPaginationAndDTOPageUrlPattern);
      });

      it('edit button click should load edit EntityWithServiceClassPaginationAndDTO page', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('EntityWithServiceClassPaginationAndDTO');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', entityWithServiceClassPaginationAndDTOPageUrlPattern);
      });

      it('last delete button click should delete instance of EntityWithServiceClassPaginationAndDTO', () => {
        cy.get(entityDeleteButtonSelector).last().click();
        cy.getEntityDeleteDialogHeading('entityWithServiceClassPaginationAndDTO').should('exist');
        cy.get(entityConfirmDeleteButtonSelector).click({ force: true });
        cy.wait('@deleteEntityRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(204);
        });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', entityWithServiceClassPaginationAndDTOPageUrlPattern);

        entityWithServiceClassPaginationAndDTO = undefined;
      });
    });
  });

  describe('new EntityWithServiceClassPaginationAndDTO page', () => {
    beforeEach(() => {
      cy.visit(`${entityWithServiceClassPaginationAndDTOPageUrl}`);
      cy.get(entityCreateButtonSelector).click({ force: true });
      cy.getEntityCreateUpdateHeading('EntityWithServiceClassPaginationAndDTO');
    });

    it('should create an instance of EntityWithServiceClassPaginationAndDTO', () => {
      cy.get(`[data-cy="lena"]`).type('Guinea optical 24/7').should('have.value', 'Guinea optical 24/7');

      cy.get(entityCreateSaveButtonSelector).click();

      cy.wait('@postEntityRequest').then(({ response }) => {
        expect(response!.statusCode).to.equal(201);
        entityWithServiceClassPaginationAndDTO = response!.body;
      });
      cy.wait('@entitiesRequest').then(({ response }) => {
        expect(response!.statusCode).to.equal(200);
      });
      cy.url().should('match', entityWithServiceClassPaginationAndDTOPageUrlPattern);
    });
  });
});
