import React from 'react';
import workoutPlan from '../../assets/images/workout-plan.jpg';
import nutritionPlan from '../../assets/images/nutrition-plan.jpg';
import personalTraining from '../../assets/images/personal-training.jpg';
import supplements from '../../assets/images/supplements.jpg';

const infoItems = [
  {
    paragraph:
      'Choose between different workout plans that suit Your personal goals.',
    imageSrc: workoutPlan,
    imageAlt: 'workout-plan picture'
  },
  {
    paragraph:
      'Fix Your diet using this guide to learn to take control of Your nutrition',
    imageSrc: nutritionPlan,
    imageAlt: 'nutrition-plan picture'
  },
  {
    paragraph:
      'Get personal coaching to get a personalized approach to achieve Your goals faster and more efficiently',
    imageSrc: personalTraining,
    imageAlt: 'personal-training picture'
  },
  {
    paragraph: 'Supplements, training equipment, anything You need',
    imageSrc: supplements,
    imageAlt: 'supplements picture'
  }
];

export const Information = () => {
  return (
    <div className="flex flex-col gap-12 p-20 bg-slate-200 text-zinc-900 text-center">
      <h2 className="text-4xl font-black">Information Section</h2>
      <div className="flex flex-row flex-wrap justify-center gap-3 p-3">
        {infoItems.map((item, index) => {
          return (
            <div className="w-[300px] p-3 flex flex-col" key={index}>
              <img
                className="w-[300px] border-4 rounded border-solid border-blue-700"
                src={item.imageSrc}
                alt={item.imageAlt}
              />
              <p>{item.paragraph}</p>
            </div>
          );
        })}
      </div>
    </div>
  );
};
