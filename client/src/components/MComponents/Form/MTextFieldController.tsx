import { TextField, Typography } from "@mui/material";
import { Control, Controller } from "react-hook-form";

interface MTextFieldControllerProps {
  control: Control<any>;
  id: string;
  name: string;
  type?: "text" | "password";
  label?: string;
  multiline?: boolean;
  maxLength?: number;
  hint?: string;
  rules?: any;
}
const MTextFieldController: React.FC<MTextFieldControllerProps> = ({
  control,
  name,
  label,
  multiline = false,
  type = "text",
  maxLength,
  rules,
}: MTextFieldControllerProps) => {
  return (
    <Controller
      name={name}
      control={control}
      rules={rules}
      render={({
        field: { onChange,onBlur, value },
        fieldState: { error },
        formState,
      }) => (
        <div className="tw-flex tw-flex-col tw-gap-1">
          {label && <Typography variant="subtitle2"> {label}</Typography>}
          <TextField
            id="outlined-basic"
            type={type}
            hiddenLabel={true}
            variant="outlined"
            size="small"
            margin="dense"
            multiline={multiline}
            rows={multiline ? 6 : 0}
            sx={{
              margin: 0,
              fontSize: 8,
            }}
            slotProps={{
              input: {
                // style: { fontSize: 13 },
              },
            }}
            onChange={onChange}
            onBlur={onBlur}
            value={value}
            error={!!error}
            helperText={error?.message}
          />
        </div>
      )}
    />
  );
};
export default MTextFieldController;
