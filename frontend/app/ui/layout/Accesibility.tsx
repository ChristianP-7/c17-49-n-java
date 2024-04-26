'use client';
import { useEffect } from 'react';
import { Accessibility } from 'accessibility';

interface IconOptions {
  circular: boolean;
  img: 'accessibility' | 'accessible';
  useEmojis: boolean;
}

interface ModulesOptions {
  increaseText: boolean;
  decreaseText: boolean;
  invertColors: boolean;
  increaseTextSpacing: boolean;
  decreaseTextSpacing: boolean;
  increaseLineHeight: boolean;
  decreaseLineHeight: boolean;
  grayHues: boolean;
  underlineLinks: boolean;
  bigCursor: boolean;
  readingGuide: boolean;
  textToSpeech: boolean;
  speechToText: boolean;
  disableAnimations: boolean;
  hotkeyPrefix: string;
}

interface Language {
  textToSpeechLang: string;
  speechToTextLang: string;
}

const labels = {
  resetTitle: 'Reiniciar',
  closeTitle: 'Cerrar',
  menuTitle: 'Menu de Accesibilidad',
  increaseText: 'Aumentar texto',
  decreaseText: 'Reducir texto',
  increaseTextSpacing: 'Aumentar el espacio del texto',
  decreaseTextSpacing: 'Disminuir el espacio del texto',
  increaseLineHeight: 'Aumentar la altura de la línea',
  decreaseLineHeight: 'Disminuir la altura de la línea',
  invertColors: 'Invertir colores',
  grayHues: 'Activar tonos grises',
  underlineLinks: 'Enlaces subrayados',
  bigCursor: 'Cursor grande',
  readingGuide: 'Guía de lectura',
  textToSpeech: 'Texto a voz',
  speechToText: 'Dictado a texto',
  disableAnimations: 'Deshabilitar animaciones',
  hotkeyPrefix: 'Acceso directo:',
};

const initAccessibility = () => {
  const options = {
    labels: labels,
    language: {
      speechToTextLang: 'es-US',
      textToSpeechLang: 'es-US',
    } as Language,
    icon: {
      circular: true,
      backgroundColor: '#0c8eae',
      color: '#fff',
      img: 'accessibility',
      useEmojis: false,
      position: {
        top: { size: 50, units: 'vh' },
        /* left: { size: 95, units: '%' }, */
        type: 'fixed',
      },
    } as IconOptions,
    modules: {
      increaseText: false,
      decreaseText: false,
      invertColors: true,
      increaseTextSpacing: true,
      decreaseTextSpacing: true,
      increaseLineHeight: true,
      decreaseLineHeight: true,
      grayHues: true,
      underlineLinks: true,
      bigCursor: true,
      readingGuide: true,
      textToSpeech: true,
      speechToText: true,
      disableAnimations: true,
    } as ModulesOptions,
  };

  new Accessibility(options);
};

const AccessibilityComponent = () => {
  useEffect(() => {
    initAccessibility();
  }, []); // Ejecutar solo una vez después de que el componente se monte

  return null;
};

export default AccessibilityComponent;
