package learn.DSA.LearnStrings;

public class StringExample {

    public static final String DATA = """
            GetUserInfo; true; JSON; 200; 150ms
            UpdateProfile; true; XML; 401; 800ms
            DeleteAccount; false; JSON; 204; 450ms
            AuthenticateUser; false; JSON; 200; 50ms
            ListProducts; false; XML; 200; 220ms
            CreateOrder; true; JSON; 201; 600ms
            CheckInventory; false; JSON; 200; 120ms
            UploadFile; true; XML; 200; 1500ms
            DownloadFile; false; JSON; 200; 900ms
            SearchCatalog; false; JSON; 200; 310ms
            GetProductDetails; false; JSON; 200; 180ms
            AddProductToCart; true; JSON; 200; 250ms
            RemoveProductFromCart; true; JSON; 200; 230ms
            Checkout; true; JSON; 200; 1100ms
            GetOrderHistory; false; JSON; 200; 400ms
            CancelOrder; true; JSON; 200; 550ms
            UpdateAddress; true; JSON; 200; 300ms
            ChangePassword; true; JSON; 200; 100ms
            ResetPassword; false; JSON; 200; 90ms
            VerifyEmail; false; JSON; 200; 60ms
            GetNotifications; false; JSON; 200; 140ms
            MarkNotificationAsRead; true; JSON; 200; 110ms
            SubscribeToNewsletter; true; JSON; 200; 70ms
            UnsubscribeFromNewsletter; true; JSON; 200; 75ms
            GetBillingInfo; false; JSON; 200; 200ms
            UpdatePaymentMethod; true; JSON; 200; 350ms
            ProcessPayment; true; XML; 200; 750ms
            RefundPayment; true; JSON; 200; 880ms
            GetShippingInfo; false; JSON; 200; 190ms
            UpdateShippingInfo; true; JSON; 200; 290ms
            TrackOrder; false; JSON; 200; 130ms
            GetWishlist; false; JSON; 200; 210ms
            AddToWishlist; true; JSON; 200; 240ms
            RemoveFromWishlist; true; JSON; 200; 225ms
            GetCoupons; false; JSON; 200; 160ms
            ApplyCoupon; true; JSON; 200; 270ms
            RemoveCoupon; true; JSON; 200; 260ms
            ViewCart; false; JSON; 200; 200ms
            ClearCart; true; JSON; 200; 180ms
            GetCategories; false; JSON; 200; 100ms
            GetProductsByCategory; false; JSON; 200; 320ms
            GetFeaturedProducts; false; JSON; 200; 150ms
            GetNewArrivals; false; JSON; 200; 165ms
            GetSaleItems; false; JSON; 200; 145ms
            SubmitReview; true; JSON; 201; 400ms
            GetReviews; false; JSON; 200; 280ms
            UpdateReview; true; JSON; 200; 330ms
            DeleteReview; true; JSON; 200; 315ms
            GetSupportTickets; false; JSON; 200; 450ms
            SubmitSupportTicket; true; JSON; 201; 550ms
            UpdateSupportTicket; true; JSON; 200; 480ms
            CloseSupportTicket; true; JSON; 200; 420ms
            GetFAQ; false; JSON; 200; 120ms
            SearchFAQ; false; JSON; 200; 170ms
            GetContactInfo; false; JSON; 200; 80ms
            SendMessage; false; JSON; 200; 190ms
            GetStoreLocations; false; JSON; 200; 230ms
            GetStoreDetails; false; JSON; 200; 110ms
            CheckStoreAvailability; false; JSON; 200; 240ms
            ReserveItem; true; JSON; 200; 300ms
            CancelReservation; true; JSON; 200; 290ms
            GetAppointments; false; JSON; 200; 350ms
            BookAppointment; true; JSON; 201; 650ms
            CancelAppointment; true; JSON; 200; 500ms
            UpdateAppointment; true; JSON; 200; 450ms
            GetServices; false; JSON; 200; 130ms
            GetServiceDetails; false; JSON; 200; 160ms
            RateService; true; JSON; 200; 250ms
            GetRatings; false; JSON; 200; 210ms
            GetEmployees; false; JSON; 200; 220ms
            GetEmployeeDetails; false; JSON; 200; 180ms
            ScheduleShift; true; JSON; 201; 700ms
            UpdateShift; true; JSON; 200; 600ms
            CancelShift; true; JSON; 200; 550ms
            GetTeamInfo; false; JSON; 200; 100ms
            InviteUser; true; JSON; 200; 200ms
            RemoveUser; true; JSON; 200; 180ms
            ChangeUserRole; true; JSON; 200; 240ms
            GetPermissions; false; JSON; 200; 140ms
            UpdatePermissions; true; JSON; 200; 320ms
            GetSettings; false; JSON; 200; 110ms
            UpdateSettings; true; JSON; 200; 280ms
            BackupData; false; XML; 200; 2500ms
            RestoreData; true; XML; 200; 3100ms
            GenerateReport; false; JSON; 200; 1800ms
            DownloadReport; false; JSON; 200; 950ms
            GetLogs; false; JSON; 200; 700ms
            ClearLogs; true; JSON; 200; 400ms
            RunHealthCheck; false; JSON; 200; 50ms
            GetSystemStatus; false; JSON; 200; 60ms
            RebootSystem; true; JSON; 200; 5000ms
            ShutdownSystem; true; JSON; 200; 4500ms
            UpdateSoftware; true; JSON; 200; 3500ms
            GetVersionInfo; false; JSON; 200; 40ms
            SubmitFeedback; false; JSON; 200; 170ms
            GetSurveys; false; JSON; 200; 130ms
            SubmitSurvey; true; JSON; 200; 290ms
            GetDashboardData; false; JSON; 200; 420ms
            GetAnalytics; false; JSON; 200; 550ms
            ExportData; false; XML; 200; 1200ms
            ImportData; true; XML; 200; 1800ms
            """;

    public static void main(String[] args) {
        String[] lines = DATA.split("\n");
        System.out.println("Path   ReadAndWriteAccess RequestFormat Status  Duration");
        for (String str : lines) {
            String[] data = str.trim().split(";");
            System.out.println(data[0] + "  " + data[1] + " " + data[2] + " "
                    + ((Integer.valueOf(data[3].trim()) >= 400) ? "FAILED" : "SUCCESS") + " " + data[4]);
        }
    }
}
