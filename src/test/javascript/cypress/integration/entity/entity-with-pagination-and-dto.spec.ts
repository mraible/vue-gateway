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

describe('EntityWithPaginationAndDTO e2e test', () => {
  const entityWithPaginationAndDTOPageUrl = '/entity-with-pagination-and-dto';
  const entityWithPaginationAndDTOPageUrlPattern = new RegExp('/entity-with-pagination-and-dto(\\?.*)?$');
  const username = Cypress.env('E2E_USERNAME') ?? 'admin';
  const password = Cypress.env('E2E_PASSWORD') ?? 'admin';
  const entityWithPaginationAndDTOSample = { lea: 'Corporate payment New' };

  let entityWithPaginationAndDTO: any;

  before(() => {
    cy.window().then(win => {
      win.sessionStorage.clear();
    });
    cy.visit('');
    cy.login(username, password);
    cy.get(entityItemSelector).should('exist');
  });

  beforeEach(() => {
    cy.intercept('GET', '/api/entity-with-pagination-and-dtos+(?*|)').as('entitiesRequest');
    cy.intercept('POST', '/api/entity-with-pagination-and-dtos').as('postEntityRequest');
    cy.intercept('DELETE', '/api/entity-with-pagination-and-dtos/*').as('deleteEntityRequest');
  });

  afterEach(() => {
    if (entityWithPaginationAndDTO) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/entity-with-pagination-and-dtos/${entityWithPaginationAndDTO.id}`,
      }).then(() => {
        entityWithPaginationAndDTO = undefined;
      });
    }
  });

  it('EntityWithPaginationAndDTOS menu should load EntityWithPaginationAndDTOS page', () => {
    cy.visit('/');
    cy.clickOnEntityMenuItem('entity-with-pagination-and-dto');
    cy.wait('@entitiesRequest').then(({ response }) => {
      if (response!.body.length === 0) {
        cy.get(entityTableSelector).should('not.exist');
      } else {
        cy.get(entityTableSelector).should('exist');
      }
    });
    cy.getEntityHeading('EntityWithPaginationAndDTO').should('exist');
    cy.url().should('match', entityWithPaginationAndDTOPageUrlPattern);
  });

  describe('EntityWithPaginationAndDTO page', () => {
    describe('create button click', () => {
      beforeEach(() => {
        cy.visit(entityWithPaginationAndDTOPageUrl);
        cy.wait('@entitiesRequest');
      });

      it('should load create EntityWithPaginationAndDTO page', () => {
        cy.get(entityCreateButtonSelector).click({ force: true });
        cy.url().should('match', new RegExp('/entity-with-pagination-and-dto/new$'));
        cy.getEntityCreateUpdateHeading('EntityWithPaginationAndDTO');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', entityWithPaginationAndDTOPageUrlPattern);
      });
    });

    describe('with existing value', () => {
      beforeEach(() => {
        cy.authenticatedRequest({
          method: 'POST',
          url: '/api/entity-with-pagination-and-dtos',
          body: entityWithPaginationAndDTOSample,
        }).then(({ body }) => {
          entityWithPaginationAndDTO = body;

          cy.intercept(
            {
              method: 'GET',
              url: '/api/entity-with-pagination-and-dtos+(?*|)',
              times: 1,
            },
            {
              statusCode: 200,
              headers: {
                link: '<http://localhost/api/entity-with-pagination-and-dtos?page=0&size=20>; rel="last",<http://localhost/api/entity-with-pagination-and-dtos?page=0&size=20>; rel="first"',
              },
              body: [entityWithPaginationAndDTO],
            }
          ).as('entitiesRequestInternal');
        });

        cy.visit(entityWithPaginationAndDTOPageUrl);

        cy.wait('@entitiesRequestInternal');
      });

      it('detail button click should load details EntityWithPaginationAndDTO page', () => {
        cy.get(entityDetailsButtonSelector).first().click();
        cy.getEntityDetailsHeading('entityWithPaginationAndDTO');
        cy.get(entityDetailsBackButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', entityWithPaginationAndDTOPageUrlPattern);
      });

      it('edit button click should load edit EntityWithPaginationAndDTO page', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('EntityWithPaginationAndDTO');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', entityWithPaginationAndDTOPageUrlPattern);
      });

      it('last delete button click should delete instance of EntityWithPaginationAndDTO', () => {
        cy.get(entityDeleteButtonSelector).last().click();
        cy.getEntityDeleteDialogHeading('entityWithPaginationAndDTO').should('exist');
        cy.get(entityConfirmDeleteButtonSelector).click({ force: true });
        cy.wait('@deleteEntityRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(204);
        });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', entityWithPaginationAndDTOPageUrlPattern);

        entityWithPaginationAndDTO = undefined;
      });
    });
  });

  describe('new EntityWithPaginationAndDTO page', () => {
    beforeEach(() => {
      cy.visit(`${entityWithPaginationAndDTOPageUrl}`);
      cy.get(entityCreateButtonSelector).click({ force: true });
      cy.getEntityCreateUpdateHeading('EntityWithPaginationAndDTO');
    });

    it('should create an instance of EntityWithPaginationAndDTO', () => {
      cy.get(`[data-cy="lea"]`).type('ivory').should('have.value', 'ivory');

      cy.get(entityCreateSaveButtonSelector).click();

      cy.wait('@postEntityRequest').then(({ response }) => {
        expect(response!.statusCode).to.equal(201);
        entityWithPaginationAndDTO = response!.body;
      });
      cy.wait('@entitiesRequest').then(({ response }) => {
        expect(response!.statusCode).to.equal(200);
      });
      cy.url().should('match', entityWithPaginationAndDTOPageUrlPattern);
    });
  });
});
