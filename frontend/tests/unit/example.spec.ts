import { mount, shallowMount } from '@vue/test-utils';
import Crawler from '@/components/Crawler.vue';

describe('Crawler.vue', () => {
  it('should render render title', () => {
    const msg = 'new message';
    const wrapper = shallowMount(Crawler, {
      props: { msg },
    });
    expect(wrapper.text()).toMatch(msg);
  });

  describe('url', () => {
    const msg = 'new message';
    const wrapper = mount(Crawler, {
      props: { msg },
    });
    it('should render url label', () => {
      expect(wrapper.html()).toContain('<label>Url</label>');
    });
    it('should render url input', () => {
      expect(wrapper.html()).toContain('<input type="text" placeholder="Enter web page url here">');
    });
    it('should render word label', () => {
      expect(wrapper.html()).toContain('<label>Word</label>');
    });
    it('should render word label', () => {
      expect(wrapper.html()).toContain('<input type="text" placeholder="Enter word to search">');
    });
    it('should render search button', () => {
      expect(wrapper.html()).toContain('<button disabled="">Search</button>');
    });
  });
});
