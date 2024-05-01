"use client";
import { useState } from "react";

interface SioNoProps {
  mensaje: string;
}

export const SioNo: React.FC<SioNoProps> = ({ mensaje }) => {
  const [isMessageVisible, setIsMessageVisible] = useState(true);
  const onMensaje = () => {
    setIsMessageVisible(!isMessageVisible);
  };

  return (
    <dialog
      id="popup-modal"
      className={`fixed top-0 left-0 w-full h-full flex justify-center items-center bg-black bg-opacity-50 z-50  md:inset-0 max-h-full
      ${isMessageVisible ? "" : "hidden"}`}
    >
      <div className="relative p-4 w-full max-w-md max-h-full">
        <div className="relative bg-white rounded-lg shadow-xl">
          <button
            onClick={onMensaje}
            type="button"
            className="absolute top-3 end-2.5 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm w-8 h-8 ms-auto inline-flex justify-center items-center"
            data-modal-hide="popup-modal"
          >
            <svg
              className="w-3 h-3"
              aria-hidden="true"
              xmlns="http://www.w3.org/2000/svg"
              fill="none"
              viewBox="0 0 14 14"
            >
              <path
                stroke="currentColor"
                stroke-linecap="round"
                stroke-linejoin="round"
                stroke-width="2"
                d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6"
              />
            </svg>
            <span className="sr-only">Cerrar</span>
          </button>
          <div className="p-4 md:p-5 text-center">
            <svg
              className="mx-auto mb-4 text-gray-400 w-12 h-12 "
              aria-hidden="true"
              xmlns="http://www.w3.org/2000/svg"
              fill="none"
              viewBox="0 0 20 20"
            >
              <path
                stroke="currentColor"
                stroke-linecap="round"
                stroke-linejoin="round"
                stroke-width="2"
                d="M10 11V6m0 8h.01M19 10a9 9 0 1 1-18 0 9 9 0 0 1 18 0Z"
              />
            </svg>
            <h3 className="mb-5 text-lg font-normal text-gray-500 ">
              {mensaje}
            </h3>
            <div className="flex justify-center gap-4">
              <button className="text-white bg-mlt-700 hover:bg-mlt-800 hover:scale-105 duration-300   transition-colors focus:outline-none font-medium rounded-full text-sm text-center p-2 w-24">
                Confirmar
              </button>
              <button
                className="text-white bg-red-600 hover:bg-red-800 hover:scale-105 duration-300   transition-colors focus:outline-none font-medium rounded-full text-sm text-center p-2 w-24"
                onClick={onMensaje}
              >
                Cancelar
              </button>
            </div>
          </div>
        </div>
      </div>
    </dialog>
  );
};
