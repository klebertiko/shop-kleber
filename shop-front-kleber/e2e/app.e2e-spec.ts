import { ShopFrontKleberPage } from './app.po';

describe('shop-front-kleber App', () => {
  let page: ShopFrontKleberPage;

  beforeEach(() => {
    page = new ShopFrontKleberPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
