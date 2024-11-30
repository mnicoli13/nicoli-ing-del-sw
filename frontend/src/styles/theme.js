// @mui
import { createTheme } from "@mui/material/styles";
//
import palette from "./palette";

let theme = createTheme({
  palette: {
    ...palette,
  },
});

export default theme;
