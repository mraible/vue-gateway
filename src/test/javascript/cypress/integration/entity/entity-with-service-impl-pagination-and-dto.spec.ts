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

describe('EntityWithServiceImplPaginationAndDTO e2e test', () => {
  const entityWithServiceImplPaginationAndDTOPageUrl = '/entity-with-service-impl-pagination-and-dto';
  const entityWithServiceImplPaginationAndDTOPageUrlPattern = new RegExp('/entity-with-service-impl-pagination-and-dto(\\?.*)?$');
  const username = Cypress.env('E2E_USERNAME') ?? 'admin';
  const password = Cypress.env('E2E_PASSWORD') ?? 'admin';
  const entityWithServiceImplPaginationAndDTOSample = { theo: 'haptic productize bandwidth' };

  let entityWithServiceImplPaginationAndDTO: any;

  before(() => {
    cy.window().then(win => {
      win.sessionStorage.clear();
    });
    cy.visit('');
    cy.login(username, password);
    cy.get(entityItemSelector).should('exist');
  });

  beforeEach(() => {
    cy.intercept('GET', '/api/entity-with-service-impl-pagination-and-dtos+(?*|)').as('entitiesRequest');
    cy.intercept('POST', '/api/entity-with-service-impl-pagination-and-dtos').as('postEntityRequest');
    cy.intercept('DELETE', '/api/entity-with-service-impl-pagination-and-dtos/*').as('deleteEntityRequest');
  });

  afterEach(() => {
    if (entityWithServiceImplPaginationAndDTO) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/entity-with-service-impl-pagination-and-dtos/${entityWithServiceImplPaginationAndDTO.id}`,
      }).then(() => {
        entityWithServiceImplPaginationAndDTO = undefined;
      });
    }
  });

  it('EntityWithServiceImplPaginationAndDTOS menu should load EntityWithServiceImplPaginationAndDTOS page', () => {
    cy.visit('/');
    cy.clickOnEntityMenuItem('entity-with-service-impl-pagination-and-dto');
    cy.wait('@entitiesRequest').then(({ response }) => {
      if (response!.body.length === 0) {
        cy.get(entityTableSelector).should('not.exist');
      } else {
        cy.get(entityTableSelector).should('exist');
      }
    });
    cy.getEntityHeading('EntityWithServiceImplPaginationAndDTO').should('exist');
    cy.url().should('match', entityWithServiceImplPaginationAndDTOPageUrlPattern);
  });

  describe('EntityWithServiceImplPaginationAndDTO page', () => {
    describe('create button click', () => {
      beforeEach(() => {
        cy.visit(entityWithServiceImplPaginationAndDTOPageUrl);
        cy.wait('@entitiesRequest');
      });

      it('should load create EntityWithServiceImplPaginationAndDTO page', () => {
        cy.get(entityCreateButtonSelector).click({ force: true });
        cy.url().should('match', new RegExp('/entity-with-service-impl-pagination-and-dto/new$'));
        cy.getEntityCreateUpdateHeading('EntityWithServiceImplPaginationAndDTO');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', entityWithServiceImplPaginationAndDTOPageUrlPattern);
      });
    });

    describe('with existing value', () => {
      beforeEach(() => {
        cy.authenticatedRequest({
          method: 'POST',
          url: '/api/entity-with-service-impl-pagination-and-dtos',
          body: entityWithServiceImplPaginationAndDTOSample,
        }).then(({ body }) => {
          entityWithServiceImplPaginationAndDTO = body;

          cy.intercept(
            {
              method: 'GET',
              url: '/api/entity-with-service-impl-pagination-and-dtos+(?*|)',
              times: 1,
            },
            {
              statusCode: 200,
              headers: {
                link: '<http://localhost/api/entity-with-service-impl-pagination-and-dtos?page=0&size=20>; rel="last",<http://localhost/api/entity-with-service-impl-pagination-and-dtos?page=0&size=20>; rel="first"',
              },
              body: [entityWithServiceImplPaginationAndDTO],
            }
          ).as('entitiesRequestInternal');
        });

        cy.visit(entityWithServiceImplPaginationAndDTOPageUrl);

        cy.wait('@entitiesRequestInternal');
      });

      it('detail button click should load details EntityWithServiceImplPaginationAndDTO page', () => {
        cy.get(entityDetailsButtonSelector).first().click();
        cy.getEntityDetailsHeading('entityWithServiceImplPaginationAndDTO');
        cy.get(entityDetailsBackButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', entityWithServiceImplPaginationAndDTOPageUrlPattern);
      });

      it('edit button click should load edit EntityWithServiceImplPaginationAndDTO page', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('EntityWithServiceImplPaginationAndDTO');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', entityWithServiceImplPaginationAndDTOPageUrlPattern);
      });

      it('last delete button click should delete instance of EntityWithServiceImplPaginationAndDTO', () => {
        cy.get(entityDeleteButtonSelector).last().click();
        cy.getEntityDeleteDialogHeading('entityWithServiceImplPaginationAndDTO').should('exist');
        cy.get(entityConfirmDeleteButtonSelector).click({ force: true });
        cy.wait('@deleteEntityRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(204);
        });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', entityWithServiceImplPaginationAndDTOPageUrlPattern);

        entityWithServiceImplPaginationAndDTO = undefined;
      });
    });
  });

  describe('new EntityWithServiceImplPaginationAndDTO page', () => {
    beforeEach(() => {
      cy.visit(`${entityWithServiceImplPaginationAndDTOPageUrl}`);
      cy.get(entityCreateButtonSelector).click({ force: true });
      cy.getEntityCreateUpdateHeading('EntityWithServiceImplPaginationAndDTO');
    });

    it('should create an instance of EntityWithServiceImplPaginationAndDTO', () => {
      cy.get(`[data-cy="theo"]`).type('Namibia').should('have.value', 'Namibia');

      cy.get(entityCreateSaveButtonSelector).click();

      cy.wait('@postEntityRequest').then(({ response }) => {
        expect(response!.statusCode).to.equal(201);
        entityWithServiceImplPaginationAndDTO = response!.body;
      });
      cy.wait('@entitiesRequest').then(({ response }) => {
        expect(response!.statusCode).to.equal(200);
      });
      cy.url().should('match', entityWithServiceImplPaginationAndDTOPageUrlPattern);
    });
  });
});
