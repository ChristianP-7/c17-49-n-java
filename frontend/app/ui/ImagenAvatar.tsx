import Image from 'next/image';
import ImageProfile from '../../public/imageProfile/avatar.png';

interface Props {
  imagen: string;
  height: number;
  width: number;
}

export const ImagenAvatar = ({ imagen, height, width }: Props) => {
  return (
    <Image
      src={ImageProfile}
      alt="imagen avatar"
      className="p-1 rounded-full ring-2 ring-white"
      style={{
        objectFit: 'cover',
        width: width,
        height: height,
        zIndex: 0,
      }}
    />
  );
};
