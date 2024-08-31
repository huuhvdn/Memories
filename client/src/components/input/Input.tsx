export type InputProps = {
  id: string;
  label: string;
  type: "text" | "password" | "file";
  placeholderText?: string;
  required?: boolean;
  disable?: boolean;
  classNames?: string;
};
export default function Input({
  type = "text",
  placeholderText = "",
  disable = false,
  required = false,
  id,
  label,
  classNames,
}: InputProps) {
  return (
    <div>
      {label && (
        <label
          htmlFor={id}
          className="tw-block tw-mb-1 tw-text-xs tw-font-medium tw-text-slate-600"
        >
          {label}
        </label>
      )}

      <input
        type="text"
        id={id}
        className="tw-bg-transparent tw-border tw-border-gray-300 tw-text-xs tw-rounded-lg focus:tw-ring-blue-500 focus:tw-border-blue-500 tw-block tw-w-full tw-p-2"
        placeholder={placeholderText}
        required={required}
      />
    </div>
  );
}
