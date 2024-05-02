'use client';
import Image from 'next/image';
import { ImagenAvatar } from '../ImagenAvatar';
import Link from 'next/link';
import {
  CalendarDaysIcon,
  DevicePhoneMobileIcon,
  DocumentTextIcon,
  VideoCameraIcon,
} from '@heroicons/react/24/outline';
import { useUserStore } from '@/store/userStore';

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
    icon: DevicePhoneMobileIcon,
  },
];

const linksPaciente: Link[] = [
  { name: 'Reserva de turnos', href: '/dashboard', icon: CalendarDaysIcon },
  { name: 'Mis consultas', href: '/dashboard/misConsultas', icon: DocumentTextIcon },
  { name: 'Atención virtual', href: '/dashboard/atencionVirtual', icon: VideoCameraIcon },
];

links = doctor ? linksDoctor : linksPaciente;

export const NavbarMovil = () => {
  const calling = useUserStore((state) => state.isInProgressCall);
  return (
    <section
      className={`${
        calling ? 'hidden' : 'flex'
      } flex relative flex-col mx-2 overflow-hidden max-w-[340px] -mt-44 justify-center items-center p-4 space-x-1 bg-white rounded-xl shadow-lg box-content md:hidden`}>
      <header className="flex justify-center items-center">
        <Image
          src="/Medilatam.svg"
          alt="logo de la aplicación web"
          height={150}
          width={200}
          className="pl-5 pt-3"
        />
      </header>
      <div className="flex space-y-2 space-x-6 items-center mt-4 justify-center">
        <ImagenAvatar imagen={'/imageProfile/avatar.png'} width={100} height={100} />
        <div className="flex space-x-3 pb-4  border-b-2">
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
      <nav className="flex w-96 mt-2 px-6">
        {links.map((link) => {
          const LinkIcon = link.icon;
          return (
            <a
              key={link.name}
              href={link.href}
              className="flex w-10 grow flex-col items-center justify-center px-0 rounded-md py-3 font-medium hover:bg-mlt-700 group hover:text-white">
              <LinkIcon className="w-8" title={link.name} />
              <p className="text-[6px] font-semibold group-hover:text-white">{link.name}</p>
            </a>
          );
        })}
      </nav>
    </section>
  );
};
