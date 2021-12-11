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

describe('EntityWithServiceImplAndDTO e2e test', () => {
  const entityWithServiceImplAndDTOPageUrl = '/entity-with-service-impl-and-dto';
  const entityWithServiceImplAndDTOPageUrlPattern = new RegExp('/entity-with-service-impl-and-dto(\\?.*)?$');
  const username = Cypress.env('E2E_USERNAME') ?? 'admin';
  const password = Cypress.env('E2E_PASSWORD') ?? 'admin';
  const entityWithServiceImplAndDTOSample = { louis: 'Incredible' };

  let entityWithServiceImplAndDTO: any;

  before(() => {
    cy.window().then(win => {
      win.sessionStorage.clear();
    });
    cy.visit('');
    cy.login(username, password);
    cy.get(entityItemSelector).should('exist');
  });

  beforeEach(() => {
    cy.intercept('GET', '/api/entity-with-service-impl-and-dtos+(?*|)').as('entitiesRequest');
    cy.intercept('POST', '/api/entity-with-service-impl-and-dtos').as('postEntityRequest');
    cy.intercept('DELETE', '/api/entity-with-service-impl-and-dtos/*').as('deleteEntityRequest');
  });

  afterEach(() => {
    if (entityWithServiceImplAndDTO) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/entity-with-service-impl-and-dtos/${entityWithServiceImplAndDTO.id}`,
      }).then(() => {
        entityWithServiceImplAndDTO = undefined;
      });
    }
  });

  it('EntityWithServiceImplAndDTOS menu should load EntityWithServiceImplAndDTOS page', () => {
    cy.visit('/');
    cy.clickOnEntityMenuItem('entity-with-service-impl-and-dto');
    cy.wait('@entitiesRequest').then(({ response }) => {
      if (response!.body.length === 0) {
        cy.get(entityTableSelector).should('not.exist');
      } else {
        cy.get(entityTableSelector).should('exist');
      }
    });
    cy.getEntityHeading('EntityWithServiceImplAndDTO').should('exist');
    cy.url().should('match', entityWithServiceImplAndDTOPageUrlPattern);
  });

  describe('EntityWithServiceImplAndDTO page', () => {
    describe('create button click', () => {
      beforeEach(() => {
        cy.visit(entityWithServiceImplAndDTOPageUrl);
        cy.wait('@entitiesRequest');
      });

      it('should load create EntityWithServiceImplAndDTO page', () => {
        cy.get(entityCreateButtonSelector).click({ force: true });
        cy.url().should('match', new RegExp('/entity-with-service-impl-and-dto/new$'));
        cy.getEntityCreateUpdateHeading('EntityWithServiceImplAndDTO');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', entityWithServiceImplAndDTOPageUrlPattern);
      });
    });

    describe('with existing value', () => {
      beforeEach(() => {
        cy.authenticatedRequest({
          method: 'POST',
          url: '/api/entity-with-service-impl-and-dtos',
          body: entityWithServiceImplAndDTOSample,
        }).then(({ body }) => {
          entityWithServiceImplAndDTO = body;

          cy.intercept(
            {
              method: 'GET',
              url: '/api/entity-with-service-impl-and-dtos+(?*|)',
              times: 1,
            },
            {
              statusCode: 200,
              body: [entityWithServiceImplAndDTO],
            }
          ).as('entitiesRequestInternal');
        });

        cy.visit(entityWithServiceImplAndDTOPageUrl);

        cy.wait('@entitiesRequestInternal');
      });

      it('detail button click should load details EntityWithServiceImplAndDTO page', () => {
        cy.get(entityDetailsButtonSelector).first().click();
        cy.getEntityDetailsHeading('entityWithServiceImplAndDTO');
        cy.get(entityDetailsBackButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', entityWithServiceImplAndDTOPageUrlPattern);
      });

      it('edit button click should load edit EntityWithServiceImplAndDTO page', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('EntityWithServiceImplAndDTO');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', entityWithServiceImplAndDTOPageUrlPattern);
      });

      it('last delete button click should delete instance of EntityWithServiceImplAndDTO', () => {
        cy.get(entityDeleteButtonSelector).last().click();
        cy.getEntityDeleteDialogHeading('entityWithServiceImplAndDTO').should('exist');
        cy.get(entityConfirmDeleteButtonSelector).click({ force: true });
        cy.wait('@deleteEntityRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(204);
        });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', entityWithServiceImplAndDTOPageUrlPattern);

        entityWithServiceImplAndDTO = undefined;
      });
    });
  });

  describe('new EntityWithServiceImplAndDTO page', () => {
    beforeEach(() => {
      cy.visit(`${entityWithServiceImplAndDTOPageUrl}`);
      cy.get(entityCreateButtonSelector).click({ force: true });
      cy.getEntityCreateUpdateHeading('EntityWithServiceImplAndDTO');
    });

    it('should create an instance of EntityWithServiceImplAndDTO', () => {
      cy.get(`[data-cy="louis"]`).type('Handmade enterprise').should('have.value', 'Handmade enterprise');

      cy.get(entityCreateSaveButtonSelector).click();

      cy.wait('@postEntityRequest').then(({ response }) => {
        expect(response!.statusCode).to.equal(201);
        entityWithServiceImplAndDTO = response!.body;
      });
      cy.wait('@entitiesRequest').then(({ response }) => {
        expect(response!.statusCode).to.equal(200);
      });
      cy.url().should('match', entityWithServiceImplAndDTOPageUrlPattern);
    });
  });
});
