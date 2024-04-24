import {
  AtSymbolIcon,
  BuildingLibraryIcon,
  KeyIcon,
  UserCircleIcon,
} from '@heroicons/react/24/outline';
import { BotonPrincipal } from '../layout/BotonPrincipal';
import { ImagenAvatar } from '../ImagenAvatar';
import Link from 'next/link';
import { AddImage } from './AddImage';

export const RegisterFormDoc = () => {
  return (
    <div className="flex flex-col mt-12">
      <div className="flex w-full justify-between -mb-28 relative">
        <Link
          className="bg-mlt-500 text-white font-semibold items-center w-36 justify-end pr-20 flex flex-row rounded-2xl h-16 hover:scale-110 duration-300"
          href="/">
          Salir
        </Link>
        <Link
          className="bg-mlt-500 text-white font-semibold items-center w-36 justify-end px-6 flex flex-row rounded-2xl h-16 hover:scale-110 duration-300"
          href="/">
          Paciente
        </Link>
      </div>
      <div className="flex justify-center -mb-20">
        <ImagenAvatar imagen="/imageProfile/avatarP.png" height={200} width={200} />
      </div>
      <form className="space-y-3">
        <div className="flex-1 rounded-xl bg-white px-6 pb-4 pt-8">
          <div className="flex flex-col pt-12 text-2xl items-center text-gray-900">
            <h1 className="text-2xl font-semibold">Bienvenido</h1>
            <h2>Registro</h2>
          </div>
          <div className="w-full mb-2">
            <div className="flex items-center gap-4">
              <div>
                <label
                  className="mb-2 mt-1 block text-xs font-medium text-gray-900"
                  htmlFor="nombre">
                  Nombre
                </label>
                <div className="relative">
                  <input
                    className="peer block w-44 rounded-md border border-gray-200 py-[2px] pl-9 text-sm outline-2 placeholder:text-gray-500"
                    id="nombre"
                    type="text"
                    name="nombre"
                    placeholder="Ingrese su Nombre"
                    required
                  />
                  <UserCircleIcon className="pointer-events-none absolute left-3 top-1/2 h-[18px] w-[18px] -translate-y-1/2 text-gray-500 peer-focus:text-gray-900" />
                </div>
              </div>
              <div>
                <label
                  className="mb-2 mt-1 block text-xs font-medium text-gray-900"
                  htmlFor="nombre">
                  Matricula
                </label>
                <div className="relative">
                  <input
                    className="peer block w-44 rounded-md border border-gray-200 py-[2px] pl-9 text-sm outline-2 placeholder:text-gray-500"
                    id="nombre"
                    type="text"
                    name="nombre"
                    placeholder="Ingrese su matricula"
                    required
                  />
                  <BuildingLibraryIcon className="pointer-events-none absolute left-3 top-1/2 h-[18px] w-[18px] -translate-y-1/2 text-gray-500 peer-focus:text-gray-900" />
                </div>
              </div>
            </div>
            <div>
              <label className="mb-1 mt-2 block text-xs font-medium text-gray-900" htmlFor="email">
                Email
              </label>
              <div className="relative">
                <input
                  className="peer block w-full rounded-md border border-gray-200 py-[2px] pl-10 text-sm outline-2 placeholder:text-gray-500"
                  id="email"
                  type="email"
                  name="email"
                  placeholder="Ingrese su Email"
                  required
                />
                <AtSymbolIcon className="pointer-events-none absolute left-3 top-1/2 h-[18px] w-[18px] -translate-y-1/2 text-gray-500 peer-focus:text-gray-900" />
              </div>
            </div>
            <div className="mt-4">
              <label
                className="mb-1 mt-5 block text-xs font-medium text-gray-900"
                htmlFor="password">
                Password
              </label>
              <div className="relative">
                <input
                  className="peer block w-full rounded-md border border-gray-200 py-[2px] pl-10 text-sm outline-2 placeholder:text-gray-500"
                  id="password"
                  type="password"
                  name="password"
                  placeholder="Ingrese una Clave"
                  required
                  minLength={6}
                />
                <KeyIcon className="pointer-events-none absolute left-3 top-1/2 h-[18px] w-[18px] -translate-y-1/2 text-gray-500 peer-focus:text-gray-900" />
              </div>
            </div>
            <div className="mt-4">
              <label
                className="mb-1 mt-1 block text-xs font-medium text-gray-900"
                htmlFor="password">
                Imagen de Perfil
              </label>
              <div className="relative">
                <AddImage />
              </div>
            </div>
          </div>
          <div className="flex justify-center space-x-4 items-center mt-4">
            <BotonPrincipal name="Registrarse" />
            <a
              className="text-mlt-700 font-semibold hover:scale-105 duration-300 hover:text-mlt-800"
              href="/auth">
              Login
            </a>
          </div>
        </div>
      </form>
    </div>
  );
};
