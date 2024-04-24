import { ArrowUpTrayIcon } from '@heroicons/react/24/outline';

export const AddImage = () => {
  return (
    <div className="flex items-center justify-center w-full h-19">
      <label className="flex flex-col items-center justify-center md:w-full h-16 border-2 pb-2 px-4 border-gray-300 border-dashed rounded-lg cursor-pointer bg-gray-50 hover:bg-gray-400">
        <div className="flex flex-col items-center justify-center md:pt-5 md:pb-6">
          <ArrowUpTrayIcon className="w-4 md:w-6 pt-3 text-gray-500 md:mb-3" />
          <p className="mb-1 text-sm text-gray-500">
            <span className="font-semibold">Haga clic para cargar</span> o arrastre y suelte la
            imagen
          </p>
        </div>
        <input id="dropzone-file" type="file" className="hidden" />
      </label>
    </div>
  );
};
