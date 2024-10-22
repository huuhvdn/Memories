import { Box, Paper, Skeleton, Stack } from "@mui/material";
import MSimpleImage from "../MSimpleImage/MSimpleImage";

interface MAlbumCardProps {
  title: string;
  imageUrl: string;
  author?: string;
  year?: number;
}

const MAlbumCard: React.FC<MAlbumCardProps> = ({
  title,
  imageUrl,
  author,
  year,
}: MAlbumCardProps) => {
  const styles = {};

  return (
    <Paper
      sx={{
        width: 350,
        height: 450,
        padding: 2,
      }}
    >
      <Stack spacing={2}>
        <Box sx={{ height: 300, width: "100%", rounded: 2 }}>
          {imageUrl ? (
            <MSimpleImage imageUrl={imageUrl} />
          ) : (
            <Skeleton
              variant="rounded"
              sx={{ height: "100%", width: "100%" }}
            />
          )}
        </Box>
        <div className="tw-flex tw-items-center tw-justify-center">
          <div
            className={`tw-flex-1 tw-text-2xl tw-text-wrap tw-max-w-[300px] tw-text-right tw-border-r tw-flex-wrap ${
              (year || year !== 0) && "tw-pr-4 tw-border-slate-300"
            }`}
          >
            {title ? (
              <div className="tw-break-words">{title}</div>
            ) : (
              <Skeleton />
            )}
          </div>

          {(year || year !== 0) && (
            <div className="tw-px-4 tw-text-3xl">{year}</div>
          )}
        </div>
        <div className="tw-block tw-text-center tw-text-xl">
          {author ? author : <Skeleton />}
        </div>
      </Stack>
    </Paper>
  );
};

export default MAlbumCard;
