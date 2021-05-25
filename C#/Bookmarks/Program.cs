using System;
using System.Windows.Forms;

namespace Bookmarks {

    static class Program {

        [STAThread]
        static void Main() {
            Application.SetHighDpiMode(HighDpiMode.SystemAware);
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new MainForm());
        }

        /// <summary>
        ///     Tests whether the <see cref="string"/> is null, empty or whitespaces-only, and
        ///     if its length is within <paramref name="maxLength"/>.
        /// </summary>
        /// <param name="maxLength">
        ///     The maximum length of the <see cref="string"/>.
        /// </param>
        public static bool IsValidLabel(this string str, int maxLength = int.MaxValue)
            => !string.IsNullOrWhiteSpace(str)
            && str.Length < maxLength;
    }
    
}
