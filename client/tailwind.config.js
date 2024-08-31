/** @type {import('tailwindcss').Config} */
module.exports = {
  prefix: 'tw-',
  content: [
    "./app/**/*.{js,ts,jsx,tsx,mdx}",
    "./pages/**/*.{js,ts,jsx,tsx,mdx}",
    "./components/**/*.{js,ts,jsx,tsx,mdx}",

    // Or if using `src` directory:
    "./src/**/*.{js,ts,jsx,tsx,mdx}",
  ],
  theme: {
    extend: {},
    // colors: {
    //   'maroon-1': '#973131',
    //   'maroon-2': '#e0a75e',
    //   'maroon-3': '#f9d689',
    //   'maroon-4': '#f5e7b2',
    //   'humara-1': '#f1977a',
    //   'humara-2': '#6063b5',
    //   'humara-3': '#ed7442',
    //   'humara-4': '#ace6f8',
    //   'humara-5': '#3e5dc3'
    // }
  },
  plugins: [],
}