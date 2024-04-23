import Image from 'next/image';

export const Background = () => {
  return (
    <Image
      src="/background.png"
      alt="sala de espera de hospital"
      className="h-[250px] w-full object-cover"
      width={1440}
      height={300}
      priority={true}
    />
  );
};
