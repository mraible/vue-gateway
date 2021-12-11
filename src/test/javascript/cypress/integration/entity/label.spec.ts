import { entityItemSelector } from '../../support/commands';
import { entityTableSelector, entityDetailsButtonSelector, entityDetailsBackButtonSelector } from '../../support/entity';

describe('Label e2e test', () => {
  const labelPageUrl = '/label';
  const labelPageUrlPattern = new RegExp('/label(\\?.*)?$');
  const username = Cypress.env('E2E_USERNAME') ?? 'admin';
  const password = Cypress.env('E2E_PASSWORD') ?? 'admin';
  const labelSample = { labelName: 'Rial' };

  let label: any;

  before(() => {
    cy.window().then(win => {
      win.sessionStorage.clear();
    });
    cy.visit('');
    cy.login(username, password);
    cy.get(entityItemSelector).should('exist');
  });

  beforeEach(() => {
    cy.intercept('GET', '/api/labels+(?*|)').as('entitiesRequest');
    cy.intercept('POST', '/api/labels').as('postEntityRequest');
    cy.intercept('DELETE', '/api/labels/*').as('deleteEntityRequest');
  });

  afterEach(() => {
    if (label) {
      cy.authenticatedRequest({
        method: 'DELETE',
        url: `/api/labels/${label.id}`,
      }).then(() => {
        label = undefined;
      });
    }
  });

  it('Labels menu should load Labels page', () => {
    cy.visit('/');
    cy.clickOnEntityMenuItem('label');
    cy.wait('@entitiesRequest').then(({ response }) => {
      if (response!.body.length === 0) {
        cy.get(entityTableSelector).should('not.exist');
      } else {
        cy.get(entityTableSelector).should('exist');
      }
    });
    cy.getEntityHeading('Label').should('exist');
    cy.url().should('match', labelPageUrlPattern);
  });

  describe('Label page', () => {
    describe('with existing value', () => {
      beforeEach(function () {
        cy.visit(labelPageUrl);

        cy.wait('@entitiesRequest').then(({ response }) => {
          if (response!.body.length === 0) {
            this.skip();
          }
        });
      });

      it('detail button click should load details Label page', () => {
        cy.get(entityDetailsButtonSelector).first().click();
        cy.getEntityDetailsHeading('label');
        cy.get(entityDetailsBackButtonSelector).click({ force: true });
        cy.wait('@entitiesRequest').then(({ response }) => {
          expect(response!.statusCode).to.equal(200);
        });
        cy.url().should('match', labelPageUrlPattern);
      });
    });
  });
});
