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

describe('MapsIdUserProfileWithDTO e2e test', () => {
  const mapsIdUserProfileWithDTOPageUrl = '/maps-id-user-profile-with-dto';
  const mapsIdUserProfileWithDTOPageUrlPattern = new RegExp('/maps-id-user-profile-with-dto(\\?.*)?$');
  const username = Cypress.env('E2E_USERNAME') ?? 'admin';
  const password = Cypress.env('E2E_PASSWORD') ?? 'admin';
  const mapsIdUserProfileWithDTOSample = { dateOfBirth: '2019-01-16T16:33:00.643Z' };

  let mapsIdUserProfileWithDTO: any;
  //let user: any;

  before(() => {
    cy.window().then(win => {
      win.sessionStorage.clear();
    });
    cy.visit('');
    cy.login(username, password);
    cy.get(entityItemSelector).should('exist');
  });

  /* Disabled due to incompatibility
  beforeEach(() => {
    // create an instance at the required relationship entity:
    cy.authenticatedRequest({
      method: 'POST',
      url: '/api/users',
      body: {"login":"Glen Virginia","firstName":"Earnest","lastName":"Keeling"},
    }).then(({ body }) => {
      user = body;
    });
  });
   */

  beforeEach(() => {
    cy.intercept('GET', '/api/maps-id-user-profile-with-dtos+(?*|)').as('entitiesRequest');
    cy.intercept('POST', '/api/maps-id-user-profile-with-dtos').as('postEntityRequest');
    cy.intercept('DELETE', '/api/maps-id-user-profile-with-dtos/*').as('deleteEntityRequest');
  });

  /* Disabled due to incompatibility
  beforeEach(() => {
    // Simulate relationships api for better performance and reproducibility.
    cy.intercept('GET', '/api/users', {
      statusCode: 200,
      body: [user],
    });

  });
   */

  afterEach(() => {
    if (mapsIdUserProfileWithDTO) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/maps-id-user-profile-with-dtos/${mapsIdUserProfileWithDTO.id}`,
      }).then(() => {
        mapsIdUserProfileWithDTO = undefined;
      });
    }
  });

  /* Disabled due to incompatibility
  afterEach(() => {
    if (user) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/users/${user.id}`,
      }).then(() => {
        user = undefined;
      });
    }
  });
   */

  it('MapsIdUserProfileWithDTOS menu should load MapsIdUserProfileWithDTOS page', () => {
    cy.visit('/');
    cy.clickOnEntityMenuItem('maps-id-user-profile-with-dto');
    cy.wait('@entitiesRequest').then(({ response }) => {
      if (response!.body.length === 0) {
        cy.get(entityTableSelector).should('not.exist');
      } else {
        cy.get(entityTableSelector).should('exist');
      }
    });
    cy.getEntityHeading('MapsIdUserProfileWithDTO').should('exist');
    cy.url().should('match', mapsIdUserProfileWithDTOPageUrlPattern);
  });

  describe('MapsIdUserProfileWithDTO page', () => {
    describe('create button click', () => {
      beforeEach(() => {
        cy.visit(mapsIdUserProfileWithDTOPageUrl);
        cy.wait('@entitiesRequest');
      });

      it('should load create MapsIdUserProfileWithDTO page', () => {
        cy.get(entityCreateButtonSelector).click({ force: true });
        cy.url().should('match', new RegExp('/maps-id-user-profile-with-dto/new$'));
        cy.getEntityCreateUpdateHeading('MapsIdUserProfileWithDTO');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', mapsIdUserProfileWithDTOPageUrlPattern);
      });
    });

    describe('with existing value', () => {
      /* Disabled due to incompatibility
      beforeEach(() => {
        cy.authenticatedRequest({
          method: 'POST',
          url: '/api/maps-id-user-profile-with-dtos',
          body: {
            ...mapsIdUserProfileWithDTOSample,
            user: user,
          },
        }).then(({ body }) => {
          mapsIdUserProfileWithDTO = body;

          cy.intercept(
            {
              method: 'GET',
              url: '/api/maps-id-user-profile-with-dtos+(?*|)',
              times: 1,
            },
            {
              statusCode: 200,
              body: [mapsIdUserProfileWithDTO],
            }
          ).as('entitiesRequestInternal');
        });

        cy.visit(mapsIdUserProfileWithDTOPageUrl);

        cy.wait('@entitiesRequestInternal');
      });
       */

      beforeEach(function () {
        cy.visit(mapsIdUserProfileWithDTOPageUrl);

        cy.wait('@entitiesRequest').then(({ response }) => {
          if (response!.body.length === 0) {
            this.skip();
          }
        });
      });

      it('detail button click should load details MapsIdUserProfileWithDTO page', () => {
        cy.get(entityDetailsButtonSelector).first().click();
        cy.getEntityDetailsHeading('mapsIdUserProfileWithDTO');
        cy.get(entityDetailsBackButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', mapsIdUserProfileWithDTOPageUrlPattern);
      });

      it('edit button click should load edit MapsIdUserProfileWithDTO page', () => {
        cy.get(entityEditButtonSelector).first().click();
        cy.getEntityCreateUpdateHeading('MapsIdUserProfileWithDTO');
        cy.get(entityCreateSaveButtonSelector).should('exist');
        cy.get(entityCreateCancelButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', mapsIdUserProfileWithDTOPageUrlPattern);
      });

      it.skip('last delete button click should delete instance of MapsIdUserProfileWithDTO', () => {
        cy.get(entityDeleteButtonSelector).last().click();
        cy.getEntityDeleteDialogHeading('mapsIdUserProfileWithDTO').should('exist');
        cy.get(entityConfirmDeleteButtonSelector).click({ force: true });
        cy.wait('@deleteEntityRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(204);
        });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', mapsIdUserProfileWithDTOPageUrlPattern);

        mapsIdUserProfileWithDTO = undefined;
      });
    });
  });

  describe('new MapsIdUserProfileWithDTO page', () => {
    beforeEach(() => {
      cy.visit(`${mapsIdUserProfileWithDTOPageUrl}`);
      cy.get(entityCreateButtonSelector).click({ force: true });
      cy.getEntityCreateUpdateHeading('MapsIdUserProfileWithDTO');
    });

    it.skip('should create an instance of MapsIdUserProfileWithDTO', () => {
      cy.get(`[data-cy="dateOfBirth"]`).type('2019-01-16T16:29').should('have.value', '2019-01-16T16:29');

      cy.get(`[data-cy="user"]`).select(1);

      cy.get(entityCreateSaveButtonSelector).click();

      cy.wait('@postEntityRequest').then(({ response }) => {
        expect(response!.statusCode).to.equal(201);
        mapsIdUserProfileWithDTO = response!.body;
      });
      cy.wait('@entitiesRequest').then(({ response }) => {
        expect(response!.statusCode).to.equal(200);
      });
      cy.url().should('match', mapsIdUserProfileWithDTOPageUrlPattern);
    });
  });
});
