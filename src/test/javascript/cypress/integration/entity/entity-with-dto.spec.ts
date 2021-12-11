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

describe('EntityWithDTO e2e test', () => {
  const entityWithDTOPageUrl = '/entity-with-dto';
  const entityWithDTOPageUrlPattern = new RegExp('/entity-with-dto(\\?.*)?$');
  const username = Cypress.env('E2E_USERNAME') ?? 'admin';
  const password = Cypress.env('E2E_PASSWORD') ?? 'admin';
  const entityWithDTOSample = { emma: 'Developer JSON' };

  let entityWithDTO: any;

  before(() => {
    cy.window().then(win => {
      win.sessionStorage.clear();
    });
    cy.visit('');
    cy.login(username, password);
    cy.get(entityItemSelector).should('exist');
  });

  beforeEach(() => {
    cy.intercept('GET', '/api/entity-with-dtos+(?*|)').as('entitiesRequest');
    cy.intercept('POST', '/api/entity-with-dtos').as('postEntityRequest');
    cy.intercept('DELETE', '/api/entity-with-dtos/*').as('deleteEntityRequest');
  });

  afterEach(() => {
    if (entityWithDTO) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/entity-with-dtos/${entityWithDTO.id}`,
      }).then(() => {
        entityWithDTO = undefined;
      });
    }
  });

  it('EntityWithDTOS menu should load EntityWithDTOS page', () => {
    cy.visit('/');
    cy.clickOnEntityMenuItem('entity-with-dto');
    cy.wait('@entitiesRequest').then(({ response }) => {
      if (response!.body.length === 0) {
        cy.get(entityTableSelector).should('not.exist');
      } else {
        cy.get(entityTableSelector).should('exist');
      }
    });
    cy.getEntityHeading('EntityWithDTO').should('exist');
    cy.url().should('match', entityWithDTOPageUrlPattern);
  });

  describe('EntityWithDTO page', () => {
    describe('create button click', () => {
      beforeEach(() => {
        cy.visit(entityWithDTOPageUrl);
        cy.wait('@entitiesRequest');
      });

      it('should load create EntityWithDTO page', () => {
        cy.get(entityCreateButtonSelector).click({ force: true });
        cy.url().should('match', new RegExp('/entity-with-dto/new$'));
        cy.getEntityCreateUpdateHeading('EntityWithDTO');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', entityWithDTOPageUrlPattern);
      });
    });

    describe('with existing value', () => {
      beforeEach(() => {
        cy.authenticatedRequest({
          method: 'POST',
          url: '/api/entity-with-dtos',
          body: entityWithDTOSample,
        }).then(({ body }) => {
          entityWithDTO = body;

          cy.intercept(
            {
              method: 'GET',
              url: '/api/entity-with-dtos+(?*|)',
              times: 1,
            },
            {
              statusCode: 200,
              body: [entityWithDTO],
            }
          ).as('entitiesRequestInternal');
        });

        cy.visit(entityWithDTOPageUrl);

        cy.wait('@entitiesRequestInternal');
      });

      it('detail button click should load details EntityWithDTO page', () => {
        cy.get(entityDetailsButtonSelector).first().click();
        cy.getEntityDetailsHeading('entityWithDTO');
        cy.get(entityDetailsBackButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', entityWithDTOPageUrlPattern);
      });

      it('edit button click should load edit EntityWithDTO page', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('EntityWithDTO');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', entityWithDTOPageUrlPattern);
      });

      it('last delete button click should delete instance of EntityWithDTO', () => {
        cy.get(entityDeleteButtonSelector).last().click();
        cy.getEntityDeleteDialogHeading('entityWithDTO').should('exist');
        cy.get(entityConfirmDeleteButtonSelector).click({ force: true });
        cy.wait('@deleteEntityRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(204);
        });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', entityWithDTOPageUrlPattern);

        entityWithDTO = undefined;
      });
    });
  });

  describe('new EntityWithDTO page', () => {
    beforeEach(() => {
      cy.visit(`${entityWithDTOPageUrl}`);
      cy.get(entityCreateButtonSelector).click({ force: true });
      cy.getEntityCreateUpdateHeading('EntityWithDTO');
    });

    it('should create an instance of EntityWithDTO', () => {
      cy.get(`[data-cy="emma"]`).type('override robust Keyboard').should('have.value', 'override robust Keyboard');

      cy.get(entityCreateSaveButtonSelector).click();

      cy.wait('@postEntityRequest').then(({ response }) => {
        expect(response!.statusCode).to.equal(201);
        entityWithDTO = response!.body;
      });
      cy.wait('@entitiesRequest').then(({ response }) => {
        expect(response!.statusCode).to.equal(200);
      });
      cy.url().should('match', entityWithDTOPageUrlPattern);
    });
  });
});
