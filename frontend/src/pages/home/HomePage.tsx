import React from 'react';
import { Information } from './Information';
import { Intro } from './Intro';
import { Services } from './Services';
import { Testimonials } from './Testimonials';

export const HomePage = () => {
  /*
.content {
  flex: auto;
  display: flex;
  flex-direction: column;
  margin: auto;
}
*/

  return (
    <div className="flex flex-col flex-auto m-auto">
      <Intro />
      <Information />
      <Testimonials />
      <Services />
    </div>
  );
};
