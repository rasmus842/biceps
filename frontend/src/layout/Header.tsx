import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import logo from '../assets/images/biceps-logo.png';

export const Header = () => {
  const navigate = useNavigate();

  const linkClasses = 'hover:cursos-pointer hover:opacity-70';

  /*
button {
    background-color: #44449B;
    color: #DDEDF4;
    border: none;
    border-radius: 4px;
    padding: 8px;
    align-self: center;
}
  */

  return (
    <header className="fixed top-0 w-full flex items-center gap-9 p-2 text-gray-100 bg-slate-900 whitespace-nowrap">
      <div className="flex items-center gap-2 text-2xl">
        <img className="w-[72px]" src={logo} alt="logo" />
        <p>
          <strong>Big Biceps</strong>
        </p>
      </div>
      <ul className="flex ml-auto gap-3">
        <Link className={linkClasses} to="/">
          Home
        </Link>
        <Link className={linkClasses} to="/about">
          About
        </Link>
        <Link className={linkClasses} to="/contact">
          &#9993; Contact
        </Link>
        <Link className={linkClasses} to="/shop">
          Shop
        </Link>
        <Link className={linkClasses} to="/account">
          &#128100; My Account
        </Link>
      </ul>
      <button
        onClick={() => navigate('/cart')}
        className={'bg-purple-700 px-2 py-1 rounded ' + linkClasses}
      >
        &#128722; My Cart
      </button>
    </header>
  );
};
