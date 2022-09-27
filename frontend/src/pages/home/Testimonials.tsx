import React from 'react';

const testimonials = [
  {
    header: 'One of the best!',
    text: 'I used to have rather small biceps before I discovered Big Biceps. After several hours of hard work I gained 12 inches of bicep circumference. The women don\'t care, but at least my gym bros are impressed and I think one is crushing me now!',
    author: 'Rainis Myrkhaineken'
  },
  {
    header: 'Exquisite workouts and merchandise!',
    text: 'I like big biceps almost as much as I like big boobs. The former on men and the latter on women, of course. I hope one day a workout programme will be written for achieving big boobs aswell. It is simply necessary, ask anyone.',
    author: 'Tit H. Kanepileht'
  },
  {
    header: 'Not bad',
    text: 'Better than your average biceps workout plan. At least he has a minimum RPE of 9 for every exercise. Plus points for edible whey protein. Not scuffed yet.',
    author: 'Cenyan Cenius'
  },
  {
    header: 'Two words - Big Biceps!',
    text: 'That is what you will get when you follow the advice of Big Biceps. It takes courage and a lot of effort to master the art of training biceps. You have to have the right mindset, an efficient training regime, and of course, proper nutrition. Big Biceps will help unleash the true potential of your biceps!',
    author: 'Rich Piano'
  }
];

export const Testimonials = () => {
  return (
    <div className="flex flex-col">
      <h2 className="mt-8 self-center text-4xl font-black">Testimonials</h2>
      <div className="flex flex-row flex-wrap justify-center p-20 gap-20 text-2xl font-extralight">
        {testimonials.map((t, index) => {
          return (
            <div className="w-[500px]" key={index}>
              <h2 className="text-2xl">
                <em>{t.header}</em>
              </h2>
              <p>
                <em>{t.text}</em>
              </p>
              <footer className="text-right">
                <strong>- {t.author}</strong>
              </footer>
            </div>
          );
        })}
      </div>
    </div>
  );
};
