export type ButtonProps = {
  type: "button" | "submit" | "reset";
  text: string;
  theme: "primary" | "success" | "warning" | "light" | "secondary";

  // Optional
  fullWidth?: boolean;
  onClick?: () => unknown;
};

const ButtonColors = new Map<string, string>([
  ["primary", "tw-bg-blue-500 tw-text-white hover:tw-bg-blue-700"],
  ["success", "tw-bg-green-500 tw-text-white hover:tw-bg-green-700"],
  [
    "light",
    "tw-border tw-border-slate-300 tw-text-stone-600 hover:tw-bg-slate-100",
  ],
  ["secondary", "tw-bg-slate-200 tw-text-stone-600 hover:tw-bg-slate-300"],
]);
export default function Button({
  type = "button",
  theme = "primary",
  text,
  fullWidth = false,
  onClick,
}: ButtonProps) {
  const handleClick = () => {
    if (onClick) {
      onClick();
    }
  };
  return (
    <>
      <button
        onClick={handleClick}
        type={type}
        className={`tw-rounded-md tw-font-medium tw-text-sm tw-px-4 tw-py-2 ${
          fullWidth && "tw-w-full"
        } ${ButtonColors.get(theme)}`}
      >
        {text ? text : "Button"}
      </button>
    </>
  );
}
