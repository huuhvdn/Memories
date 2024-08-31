export type ButtonProps = {
  type: "button" | "submit" | "reset";
  text: string;
  theme: "primary" | "success" | "warning" | "light";
};

const ButtonColors = new Map<string, string>([
  ["primary", "tw-bg-blue-500 hover:tw-bg-blue-700"],
  ["success", "tw-bg-green-500 hover:tw-bg-green-700"],
]);
export default function Button({
  type = "button",
  theme = "primary",
  text,
}: ButtonProps) {
  return (
    <>
      <button
        type={type}
        className={`tw-text-white tw-font-medium tw-rounded-md tw-text-sm tw-px-5 tw-py-2 ${ButtonColors.get(
          theme
        )}`}
      >
        {text ? text : "Button"}
      </button>
    </>
  );
}
