import { ClearIcon } from "@/components/MComponents/Icons/icons";
import { Clear } from "@mui/icons-material";
import { Button, IconButton } from "@mui/material";

interface MButtonProps {
  text: string;
  type?: "button" | "submit" | "reset";
  color?: "primary" | "secondary" | "error" | "warning" | "info" | "success";
  size?: "small" | "medium" | "large";
  disabled?: boolean;
  startIcon?: React.ReactNode;
  endIcon?: React.ReactNode;
  theme?: "close";
  arialLabel?: string;

  onClick?: () => void;
}
const MButton: React.FC<MButtonProps> = ({
  type = "button",
  text = "",
  color = "primary",
  size = "medium",
  disabled = false,
  startIcon,
  endIcon,
  theme,
  arialLabel,
  onClick,
}: MButtonProps) => {
  const styles = {
    button: {
      textTransform: "none",
    },
  };
  return (
    <>
      {!theme && theme !== "close" ? (
        <Button
          variant="contained"
          type={type}
          color={color}
          size={size}
          disabled={disabled}
          startIcon={startIcon}
          endIcon={endIcon}
          aria-label={arialLabel}
          onClick={onClick}
          sx={styles.button}
        >
          {text}
        </Button>
      ) : (
        <IconButton
          type="button"
          color="secondary"
          aria-label={arialLabel}
          onClick={onClick}
        >
          <ClearIcon />
        </IconButton>
      )}
    </>
  );
};

export default MButton;
