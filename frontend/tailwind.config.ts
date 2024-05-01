import type { Config } from "tailwindcss";

const config: Config = {
  content: [
    "./pages/**/*.{js,ts,jsx,tsx,mdx}",
    "./components/**/*.{js,ts,jsx,tsx,mdx}",
    "./app/**/*.{js,ts,jsx,tsx,mdx}",
  ],
  theme: {
    extend: {
      colors: {
        'mlt': {
          '50': '#ecfeff',
          '100': '#d0f9fd',
          '200': '#a7f1fa',
          '300': '#6be5f5',
          '400': '#27cfe9',
          '500': '#0cc0df',
          '600': '#0c8eae',
          '700': '#11728d',
          '800': '#175d73',
          '900': '#184d61',
          '950': '#093243',
          '1000': '#000'
        },
      }
    },
  },
  plugins: [],
};
export default config;
