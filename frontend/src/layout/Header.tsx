import { Button } from '@mui/material';
import React from 'react';
import { Link } from 'react-router-dom';
import logo from '../assets/images/biceps-logo.png';

export const Header = () => {
  return (
    <header className="text-gray-100 bg-slate-900 whitespace-nowrap flex items-center gap-9 p-2">
      <div className="flex items-center gap-2 text-2xl">
        <img className="w-[72px]" src={logo} alt="logo" />
        <p>
          <strong>Big Biceps</strong>
        </p>
      </div>
      <ul className="flex ml-auto gap-3">
        <Link to="/">Home</Link>
        <Link to="/about">About</Link>
        <Link to="/contact">&#9993; Contact</Link>
        <Link to="/shop">Shop</Link>
        <Link to="/account">&#128100; My Account</Link>
      </ul>
      <Button>&#128722; My Cart</Button>
    </header>
  );
};
