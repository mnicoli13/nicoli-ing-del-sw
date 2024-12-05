import { createBrowserRouter } from "react-router-dom";
import { Navigate } from "react-router-dom";
import LoginLayout from "../layouts/LoginLayout";
import GuestGuard  from "../components/guards/GuestGuard";
import Login from "../pages/auth/Login";
const router = createBrowserRouter([
    // Auth Routes
    {
      path: "/auth",
      element: (
        <GuestGuard>
          <LoginLayout />
        </GuestGuard>
      ),
      children: [
        { element: <Navigate to="/auth/login" replace />, index: true },
        {
          path: "login",
          element: <Login />,
        },
      ],
    },
    // // Patients Routes
    // {
    //   path: "/patients",
    //   element: (
    //     <AuthGuard>
    //       <MainLayout />
    //     </AuthGuard>
    //   ),
    //   children: [
    //     { element: <Navigate to="/patients/list" replace />, index: true },
    //     {
    //       path: "list",
    //       element: <PatientsList />,
    //     },
    //     {
    //       path: "create",
    //       element: <CreatePatient />,
    //     },
    //   ],
    // },
    // // Visits Routes
    // {
    //   path: "/visits",
    //   element: (
    //     <AuthGuard>
    //       <MainLayout />
    //     </AuthGuard>
    //   ),
    //   children: [
    //     {
    //       path: "create/:patientID",
    //       element: <CreateVisit />,
    //     },
    //   ],
    // },
    // Default Routes
    {
      path: "/",
      element: <Navigate to="/auth/login" replace />,
      index: true,
    },
    // {
    //   path: "*",
    //   element: <div>404</div>,
    // },
  ]);
  
  export default router;