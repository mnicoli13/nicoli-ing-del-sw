// @mui
import { Box } from "@mui/material";
// components
// import Navbar from "../components/header/Navbar";
//
import { Outlet } from "react-router-dom";

export default function MainLayout() {
  return (
    <Box
      sx={{
        background: "#FFFFFF",
        minHeight: "100vh",
        display: "flex",
        flexDirection: "column",
        justifyContent: "space-between",
      }}
    >
      {/* <Navbar /> */}

      <Box sx={{ p: "80px 140px", flex: 2 }}>
        <Outlet />
      </Box>

    </Box>
  );
}
