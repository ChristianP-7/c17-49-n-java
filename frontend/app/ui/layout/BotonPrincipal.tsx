interface BotonProps {
  name: string;
}

export const BotonPrincipal: React.FC<BotonProps> = ({ name }) => {
  return (
    <button
      type="button"
      className="text-white bg-mlt-700 hover:bg-mlt-800 hover:scale-105 duration-300   transition-colors focus:outline-none font-medium rounded-full text-sm text-center p-2 w-24">
      {name}
    </button>
  );
};
