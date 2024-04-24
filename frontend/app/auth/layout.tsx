import Image from 'next/image';
import fondoLogin from '../../public/fondoLogin.webp';

export default function Layout({ children }: { children: React.ReactNode }) {
  return (
    <div className="flex mx-auto justify-center items-center mt-4 md:justify-normal md:mt-0 md:space-x-28 md:bg-mlt-800 max-h-[100vh]">
      <Image
        src={fondoLogin}
        alt="fondo auth"
        className="max-h-[100vh] hidden md:flex"
        style={{
          objectFit: 'cover',
          width: 750,
          height: 900,
        }}
      />
      {children}
    </div>
  );
}
