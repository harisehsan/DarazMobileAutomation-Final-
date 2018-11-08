package helper;

import java.util.Locale;
public class OsHelper {

        // cached result of OS detection
        private static String detectedOS;

        /**
         * detect the operating system from the os.name System property and cache
         * the result
         *
         * @returns - the operating system detected
         */
        public static String getOperatingSystemType() {
            if (detectedOS == null) {
                String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
                if ((OS.contains("mac")) || (OS.contains("darwin"))) {
                    detectedOS = "mac";
                } else if (OS.contains("win")) {
                    detectedOS = "windows";
                } else if (OS.contains("nux")) {
                    detectedOS = "linux";
                } else {
                    detectedOS = "other";
                }
            }
            return detectedOS;
        }
}
