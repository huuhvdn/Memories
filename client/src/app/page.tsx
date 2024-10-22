"use client";
import {
  MAlbumCard,
  MButton,
  MDatePickerController,
  MFilesUpload,
} from "@/components";
import MTextFieldController from "@/components/MComponents/Form/MTextFieldController";
import {
  AutoStoriesIcon,
  PhotoLibraryIcon,
} from "@/components/MComponents/Icons/icons";
import MainLayout from "@/components/MComponents/Layouts/MainLayout";
import { Box, Paper, Stack, Typography } from "@mui/material";
import Grid from "@mui/material/Grid2";
import { bgBG } from "@mui/x-date-pickers/locales";
import { useEffect, useState } from "react";
import { useForm } from "react-hook-form";
import AOS from "aos";
import "aos/dist/aos.css";

type MemoryAblumForm = {
  title: string;
  description: string;
  date: string;
  location: string;
  file?: File;
};

export default function HomePage() {
  const [data] = useState<number[]>([1]);

  const { control, handleSubmit, watch } = useForm<MemoryAblumForm>({
    mode: "onBlur",
    reValidateMode: "onBlur",
    defaultValues: {
      title: "",
      description: "",
      date: "",
      location: "",
    },
  });

  const formValue = watch();
  const [imagePreviewUrl, setImagePreview] = useState<string | undefined>(
    undefined
  );
  const [title, setTitle] = useState<string>("");
  const [year, setYear] = useState<number>();

  const handleFileChange = (file: File | null) => {
    if (file) {
      const previews = URL.createObjectURL(file);
      setImagePreview(previews);
    } else {
      setImagePreview(undefined);
    }
  };

  const onSubmit = async (data: MemoryAblumForm) => {
    console.log("data", data);
  };

  useEffect(() => {
    AOS.init();
  }, []);

  useEffect(() => {
    setTitle(formValue.title || "");
    handleFileChange(formValue.file || null);
    setYear(Number(formValue.date.split("-")[0]));
  }, [formValue.title, formValue.file, formValue.date]);

  return (
    <MainLayout title="Our Memories App | Home">
      {data.length > 0 ? (
        <Box sx={{ flexGrow: 1, marginTop: 4 }}>
          <Grid container>
            <Typography variant="h5">Add album</Typography>
          </Grid>
          <Grid container spacing={2}>
            <Grid size={{ xs: 12, md: 6 }}>
              <Box
                sx={{
                  width: "100%",
                  height: "100%",
                  display: "flex",
                  justifyContent: "center",
                  padding: 2,
                }}
              >
                <MAlbumCard
                  title={title}
                  year={year}
                  imageUrl={imagePreviewUrl ?? ""}
                />
              </Box>
            </Grid>
            <Grid size={{ xs: 12, md: 6 }}>
              <Box
                component="form"
                onSubmit={handleSubmit(onSubmit)}
                sx={{ maxWidth: 600, margin: "auto", padding: 2 }}
              >
                <Stack spacing={1}>
                  <MTextFieldController
                    control={control}
                    label="Name"
                    id="name"
                    name="title"
                    rules={{
                      required: {
                        value: true,
                        message: "Title is required",
                      },
                    }}
                  />
                  <MDatePickerController
                    control={control}
                    label="Date"
                    id="date"
                    name="date"
                    format="DD-MM-YYYY"
                  />
                  <MTextFieldController
                    control={control}
                    label="Location"
                    id="location"
                    name="location"
                  />
                  <MTextFieldController
                    control={control}
                    label="Description"
                    id="description"
                    name="description"
                    multiline={true}
                    rules={{
                      maxLength: {
                        value: 500,
                        message: "Description cannot exceed 500 characters",
                      },
                    }}
                  />
                  <MFilesUpload
                    control={control}
                    name="file"
                    label="Upload image"
                  />
                  <div className="tw-flex tw-justify-end">
                    <MButton
                      type="submit"
                      text="Add album"
                      startIcon={<PhotoLibraryIcon />}
                    />
                  </div>
                </Stack>
              </Box>
            </Grid>
          </Grid>
        </Box>
      ) : (
        <Paper
          data-aos="fade-down"
          sx={{ width: 300, padding: 2, marginTop: 20, marginX: "auto" }}
        >
          <Stack spacing={1}>
            <Typography variant="h6" textAlign="center">
              Create new a
            </Typography>
            <MButton
              type="button"
              text="Album"
              startIcon={<PhotoLibraryIcon />}
            />
            <p className="tw-text-center">or</p>
            <MButton
              type="button"
              text="Memory"
              startIcon={<AutoStoriesIcon />}
            ></MButton>
          </Stack>
        </Paper>
      )}
    </MainLayout>
  );
}
