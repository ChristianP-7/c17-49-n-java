import { ExclamationCircleIcon } from '@heroicons/react/24/outline';
import { CalendarIcon } from './CalendarIcon';
import { useState } from 'react';
import Link from 'next/link';
export const ConfirmarConsulta = () => {
  const [isMessageVisible, setIsMessageVisible] = useState(true);

  const onMessage = () => {
    setIsMessageVisible(!isMessageVisible);
  };
  return (
    <dialog
      id="popup-modal"
      className={`${
        isMessageVisible ? '' : 'hidden'
      } fixed top-0 left-0 w-full h-full flex justify-center items-center bg-black bg-opacity-50 z-50  md:inset-0 max-h-full`}>
      {/* // Main modal */}
      <div className="relative p-4 w-full max-w-md max-h-full">
        {/* <!-- Modal content --> */}
        <div className="relative bg-white rounded-lg shadow">
          {/* <!-- Modal header --> */}
          <div className="flex items-center justify-center p-4 md:p-5 border-b rounded-t dark:border-gray-600">
            <div className="flex flex-col justify-center items-center">
              <ExclamationCircleIcon className="w-10" />
              <h3 className="text-lg font-semibold text-gray-900 text-center">
                Confirmación de Consulta
              </h3>
            </div>
          </div>
          {/* <!-- Modal body --> */}
          <div className="p-4 md:p-5">
            <ol className="relative border-s border-gray-200  ms-3.5 mb-4 md:mb-5">
              <li className="mb-10 ms-8">
                <span className="absolute flex items-center justify-center w-6 h-6 bg-mlt-600 rounded-full -start-3.5 ring-8  ring-mlt-800">
                  <CalendarIcon />
                </span>
                <h3 className="flex items-start mb-1 text-lg font-semibold text-gray-900">
                  Viernes 01-05-2024, 16:30 Hs
                </h3>
                <p className="block mb-3 text-sm font-normal leading-none text-gray-500">
                  Fecha y Hora
                </p>
              </li>
              <li className="mb-10 ms-8">
                <span className="absolute flex items-center justify-center w-6 h-6 bg-mlt-600 rounded-full -start-3.5 ring-8  ring-mlt-800">
                  <CalendarIcon />
                </span>
                <h3 className="flex items-start mb-1 text-lg font-semibold text-gray-900">
                  Cardiologia
                </h3>
                <p className="block mb-3 text-sm font-normal leading-none text-gray-500">
                  Especialidad
                </p>
              </li>
              <li className="mb-10 ms-8">
                <span className="absolute flex items-center justify-center w-6 h-6 bg-mlt-600 rounded-full -start-3.5 ring-8  ring-mlt-800">
                  <CalendarIcon />
                </span>
                <h3 className="mb-1 text-lg font-semibold text-gray-900">Dr.Rodriguez</h3>
                <p className="block mb-3 text-sm font-normal leading-none text-gray-500">
                  Especialista
                </p>
              </li>
              <li className="ms-8">
                <span className="absolute flex items-center justify-center w-6 h-6 bg-mlt-600 rounded-full -start-3.5 ring-8  ring-mlt-800">
                  <CalendarIcon />
                </span>
                <h3 className="mb-1 text-lg font-semibold text-gray-900">$2000</h3>
                <p className="block mb-3 text-sm font-normal leading-none text-gray-500">Precio</p>
              </li>
            </ol>
            <div className="flex justify-center gap-4">
              <button
                onClick={onMessage}
                className="text-white bg-mlt-700 hover:bg-mlt-800 hover:scale-105 duration-300   transition-colors focus:outline-none font-medium rounded-full text-sm text-center p-2 w-24">
                Confirmar
              </button>
              <button
                onClick={onMessage}
                className="text-white bg-red-600 hover:bg-red-800 hover:scale-105 duration-300   transition-colors focus:outline-none font-medium rounded-full text-sm text-center p-2 w-24">
                Cancelar
              </button>
            </div>
          </div>
        </div>
      </div>
    </dialog>
  );
};
