'use client';
import Image from 'next/image';
import { ImagenAvatar } from '../ImagenAvatar';
import Link from 'next/link';
import {
  CalendarDaysIcon,
  DocumentTextIcon,
  Bars3Icon,
  XMarkIcon,
  VideoCameraIcon,
} from '@heroicons/react/24/outline';
import { useState } from 'react';

interface Link {
  name: string;
  href: string;
  icon: any;
}

const doctor = false;

let links: Link[] = [];

const linksDoctor: Link[] = [
  { name: 'Reserva de turnos Doctor', href: '/dashboard', icon: CalendarDaysIcon },
  { name: 'Mis consultas Doctor', href: '/dashboard/misConsultas', icon: DocumentTextIcon },
  {
    name: 'Atención virtual Doctor',
    href: '/dashboard/atencionVirtual',
    icon: VideoCameraIcon,
  },
];

const linksPaciente: Link[] = [
  { name: 'Reserva de turnos', href: '/dashboard', icon: CalendarDaysIcon },
  { name: 'Mis consultas', href: '/dashboard/misConsultas', icon: DocumentTextIcon },
  { name: 'Atención virtual', href: '/dashboard/atencionVirtual', icon: VideoCameraIcon },
];

links = doctor ? linksDoctor : linksPaciente;

export const Navbar = () => {
  const [isNavbarVisible, setIsNavbarVisible] = useState(true);

  const toggleNavbar = () => {
    setIsNavbarVisible(!isNavbarVisible);
  };

  return (
    <div
      className={`flex-col transition-transform duration-0 ml-6 transform hidden md:flex ${
        isNavbarVisible ? 'translate-x-0' : '-translate-x-52 w-1'
      }`}>
      <header
        className={`shadow-2xl rounded-xl w-[260px] h-[40px] bg-white  p-2 mb-3 items-center justify-end hidden md:flex`}>
        <button onClick={toggleNavbar}>
          <p className={`px-1 ${isNavbarVisible ? '' : 'hidden'}`}>Cerrar</p>
          <Bars3Icon
            title="menu"
            className={`w-6 hover:text-white rounded hover:bg-mlt-700 transition-colors duration-300 ${
              isNavbarVisible ? 'hidden' : ''
            }`}
          />
        </button>
        <button onClick={toggleNavbar}>
          <XMarkIcon
            title="cerrar"
            className={`w-6 hover:text-white rounded hover:bg-mlt-700 transition-colors duration-300 ${
              isNavbarVisible ? '' : 'hidden'
            }`}
          />
          <p className={`${isNavbarVisible ? 'hidden' : ''}`}>Menu</p>
        </button>
      </header>
      <section
        className={`flex-col rounded-xl w-[229px] h-[500px] mr-6 overflow-hidden hidden relative p-4  bg-white shadow-2xl box-content md:flex transition-transform duration-0 transform 
            ${isNavbarVisible ? 'translate-x-0' : '-translate-x-1'}`}>
        <header className={`${isNavbarVisible ? 'hidden' : 'flex flex-row-reverse w-full'}`}>
          <ImagenAvatar imagen={'/imageProfile/avatar.png'} width={60} height={60} />
        </header>
        <div className={`${isNavbarVisible ? '' : 'size-0 mb-10'}`}>
          <header>
            <Image src="/Medilatam.svg" alt="logo de la aplicación web" height={150} width={500} />
          </header>
          <div className={`flex flex-col space-y-2 items-center mt-4`}>
            <ImagenAvatar imagen={'/imageProfile/avatar.png'} width={130} height={130} />
            <div className={`flex space-x-10 pb-4 border-b-2`}>
              <a
                className="text-white bg-mlt-700 hover:bg-mlt-800 hover:scale-105 duration-300  transition-colors focus:outline-none font-medium rounded-full text-sm text-center p-2 w-24"
                href="/auth">
                Login
              </a>
              <a
                className="text-white bg-mlt-700 hover:bg-mlt-800 hover:scale-105 duration-300 transition-colors focus:outline-none font-medium rounded-full text-sm text-center p-2 w-24"
                href="/auth/register">
                Registro
              </a>
            </div>
          </div>
        </div>
        <nav className="flex flex-col space-x-0 space-y-6 w-full mt-2">
          {links.map((link) => {
            const LinkIcon = link.icon;
            return (
              <a
                key={link.name + Math.random()}
                href={link.href}
                title={link.name}
                className={`flex h-[48px] grow items-center justify-start gap-2 rounded-md px-2 text-sm font-medium hover:bg-mlt-700 group hover:text-white ${
                  isNavbarVisible ? '' : 'flex flex-row-reverse'
                }`}>
                <LinkIcon
                  className={` ${
                    isNavbarVisible ? 'w-8' : 'w-12 hover:rotate-6 hover:duration-200'
                  }`}
                />
                <p>{link.name}</p>
              </a>
            );
          })}
        </nav>
      </section>
    </div>
  );
};
