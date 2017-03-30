import { ShopKleberPage } from './app.po';

describe('shop-kleber App', () => {
  let page: ShopKleberPage;

  beforeEach(() => {
    page = new ShopKleberPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
