import type { Metadata } from 'next';
import { Inter } from 'next/font/google';
import './globals.css';

const inter = Inter({ subsets: ['latin'] });

export const metadata: Metadata = {
  title: 'Medilatam',
  description:
    'Tu portal de salud en América Latina. Conectamos a pacientes con profesionales médicos, ofreciendo consultas virtuales, herramientas de seguimiento y acceso a información médica confiable. Tu guía para una salud óptima en la región',
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="es">
      <link rel="icon" href="/favicon.svg" />
      <body className={`bg-slate-200 ${inter.className} antialiased `}>{children}</body>
    </html>
  );
}
