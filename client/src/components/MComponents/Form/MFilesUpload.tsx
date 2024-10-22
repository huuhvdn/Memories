import { Control, Controller } from "react-hook-form";
import { CloudUploadIcon } from "../Icons/icons";
import { Button, styled, Typography } from "@mui/material";

interface MFilesUploadProps {
  control: Control<any>;
  id?: string;
  name: string;
  label?: string;
}

const VisuallyHiddenInput = styled("input")({
  clip: "rect(0 0 0 0)",
  clipPath: "inset(50%)",
  height: 1,
  overflow: "hidden",
  position: "absolute",
  bottom: 0,
  left: 0,
  whiteSpace: "nowrap",
  width: 1,
});

const MFilesUpload: React.FC<MFilesUploadProps> = ({
  control,
  id,
  name,
  label
}: MFilesUploadProps) => {
  return (
    <>
      <Controller
        control={control}
        name={name}
        render={({
          field: { onChange, value },
          fieldState: { error },
          formState,
        }) => (
          <div className="tw-flex tw-gap-1 tw-flex-col">
            {label && <Typography variant="subtitle2"> {label}</Typography>}
            <div className="tw-h-56 tw-w-full tw-border-dashed tw-border-blue-500 tw-border-2 tw-rounded-md tw-flex tw-justify-center tw-items-center">
              <Button
                component="label"
                role={undefined}
                variant="contained"
                tabIndex={-1}
                startIcon={<CloudUploadIcon />}
              >
                Upload files
                <VisuallyHiddenInput
                  type="file"
                  onChange={(event) =>
                    event.target.files && onChange(event.target.files[0])
                  }
                  multiple
                />
              </Button>
            </div>
          </div>
        )}
      />
    </>
  );
};

export default MFilesUpload;
