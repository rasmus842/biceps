import React from 'react';
import barbellCurl from '../../assets/images/barbell-curl.webp';
import dumbbellCurl from '../../assets/images/dumbbell-curl.jpeg';

export const Intro = () => {
  return (
    <div className="flex justify-center content-center p-9">
      <div className="intro">
        <div className="w-[500px] m-3 flex flex-col justify-center p-3 gap-3 border-2 border-solid rounded border-zinc-900">
          <h2 className="text-5xl font-black">Welcome to Big Biceps</h2>
          <p>
            Tired of having weak and small biceps? Get in shape here at Big
            Biceps. Workout & meal plans, training equipment, personal coaching.
            Sign up today to start your journey of getting big biceps!
          </p>
          <button type="button">&#128170; Get Started</button>
        </div>
      </div>
      <picture className="flex-[0_0_auto]">
        <source srcSet={barbellCurl} type="image/webp" />
        <source srcSet={dumbbellCurl} type="image/jpeg" />
        <img
          id="intro-image"
          src={barbellCurl}
          alt="Get in shape inspirational picture"
        />
      </picture>
    </div>
  );
};
