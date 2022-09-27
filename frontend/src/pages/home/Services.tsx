import React from 'react';
import styles from './Services.module.css';

export const Services = () => {
  return (
    <div className="flex text-zinc-900">
      <div className={styles.account}>
        <h2 className={styles.header}>Register Account</h2>
        <p>Register a new account and begin your fitness journey!</p>
        <button type="button">Register Account</button>
      </div>
      <div className={styles.shop}>
        <h2 className={styles.header}>Shop</h2>
        <p>View our full catalogue of products and services.</p>
        <button type="button">View Shop</button>
      </div>
      <div className={styles.app}>
        <h2 className={styles.header}>Workout App</h2>
        <p>Download our new fitness app to track your workouts!</p>
        <button type="button">Download App</button>
      </div>
    </div>
  );
};
