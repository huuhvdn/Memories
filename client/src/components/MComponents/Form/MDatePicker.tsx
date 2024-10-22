import { DatePicker } from "@mui/x-date-pickers/DatePicker";
import { LocalizationProvider } from "@mui/x-date-pickers/LocalizationProvider/LocalizationProvider";
import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs";
import { Control, Controller } from "react-hook-form";
import dayjs from "dayjs";
import { Typography } from "@mui/material";

interface MDatePickerControllerProps {
  control?: Control<any>;
  id: string;
  name: string;
  label?: string;
  format?: "YYYY-MM-DD" | "DD-MM-YYYY";
}

const MDatePickerController: React.FC<MDatePickerControllerProps> = ({
  control,
  id,
  name,
  label,
  format = "YYYY-MM-DD",
}: MDatePickerControllerProps) => {
  return (
    <LocalizationProvider dateAdapter={AdapterDayjs}>
      <Controller
        control={control}
        name={name}
        render={({
          field: { onChange, value },
          fieldState: { error },
          formState,
        }) => (
          <div>
            {label && <Typography variant="subtitle2"> {label}</Typography>}

            <DatePicker
              aria-invalid
              slotProps={{
                textField: { size: "small", fullWidth: true },
                field: { clearable: true },
              }}
              value={value ? dayjs(value) : null}
              onChange={(newValue) => {
                const dateString = newValue
                  ? newValue.format("YYYY-MM-DD")
                  : "";
                onChange(dateString);
              }}
              format={format}
            />
          </div>
        )}
      />
    </LocalizationProvider>
  );
};

export default MDatePickerController;
// https://blog.logrocket.com/using-material-ui-with-react-hook-form/
