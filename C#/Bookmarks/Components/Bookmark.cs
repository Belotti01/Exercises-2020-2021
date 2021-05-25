using System;
using System.Diagnostics;
using System.Windows.Forms;

namespace Bookmarks.Components {

    public partial class Bookmark : UserControl {
        public BookmarkData Data { get; set; }

        public Bookmark() {
            InitializeComponent();
        }

        public Bookmark(BookmarkData bookmark) : this() {
            Data = bookmark;
            LoadData();
        }

        public void LoadData() {
            lblName.Text = string.IsNullOrWhiteSpace(Data.Name) ? Data.Url : Data.Name;
            txtDescription.Text = Data.Description;
        }

        public void ToggleEditableMode(bool editable) {
            lblName.Enabled = editable;
            lblName.ReadOnly =
            txtDescription.ReadOnly =
            btnOpen.Visible = btnOpen.Enabled =
            btnEdit.Visible = btnEdit.Enabled =
            btnRemove.Visible = btnRemove.Enabled = !editable;
        }

        private void OnOpenClick(object sender, MouseEventArgs e) {
            try {
                var startInfo = new ProcessStartInfo {
                    UseShellExecute = true,
                    FileName = Data.Url
                };
                Process process = Process.Start(startInfo);
            } catch {
                MessageBox.Show($"The provided URL \"{Data.Url}\" is not valid.\n", "Invalid URL", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }
        }

        private void OnRemoveClick(object sender, EventArgs e) {
            DialogResult confirmation = MessageBox.Show(
                "Are you sure you want to delete this Bookmark?",
                "Confirm",
                MessageBoxButtons.YesNo,
                MessageBoxIcon.Question
            );

            if(confirmation == DialogResult.Yes && Parent?.Parent is BookmarksList list) {
                list.Remove(this);
            }
        }

        private void OnEditClick(object sender, EventArgs e) {
            BookmarkSetup setup = new BookmarkSetup(Data);
            setup.ShowDialog(Parent?.Parent);
        }

    }

}
